package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.Ddd;
import br.gov.cultura.sistema.model.corporativo.DocumentacaoPessoa;
import br.gov.cultura.sistema.model.corporativo.Endereco;
import br.gov.cultura.sistema.model.corporativo.Pais;
import br.gov.cultura.sistema.model.corporativo.Pessoa;
import br.gov.cultura.sistema.model.corporativo.PessoaFisica;
import br.gov.cultura.sistema.model.corporativo.SituacaoCadastralPF;
import br.gov.cultura.sistema.model.corporativo.Telefone;
import br.gov.cultura.sistema.model.corporativo.TipoAbrangencia;
import br.gov.cultura.sistema.model.corporativo.TipoEndereco;
import br.gov.cultura.sistema.model.corporativo.TipoPessoa;
import br.gov.cultura.sistema.model.corporativo.TipoSituacaoCadastralPF;
import br.gov.cultura.sistema.model.corporativo.TipoTelefone;
import br.gov.cultura.sistema.model.enums.corporativo.PaisEnum;
import br.gov.cultura.sistema.model.enums.corporativo.TipoAbrangenciaEnum;
import br.gov.cultura.sistema.model.enums.corporativo.TipoEnderecoEnum;
import br.gov.cultura.sistema.model.enums.corporativo.TipoPessoaEnum;
import br.gov.cultura.sistema.model.enums.corporativo.TipoTelefoneEnum;
import br.gov.cultura.sistema.model.seguranca.Servico;
import br.gov.cultura.sistema.pessoa.PessoaUtils;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.service.GenericCrudService;
import br.gov.cultura.sistema.util.FormatadorUtils;
import br.gov.cultura.sistema.util.ValidacaoUtils;
import br.gov.fazenda.receita.infoconv.ws.cpf.ConsultarCPFSoap;
import br.gov.fazenda.receita.infoconv.ws.cpf.ConsultarCPFSoapProxy;
import br.gov.fazenda.receita.infoconv.ws.cpf.PessoaPerfil3;
import br.gov.fazenda.receita.infoconv.ws.util.CertificateUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

@Stateless
public class PessoaFisicaService {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    @Inject
    private GenericCrudService genericCrudService;
    @Inject
    private EnderecoService enderecoService;
    @Inject
    private LogradouroService logradouroService;
    @Inject
    private TelefoneService telefoneService;

    public PessoaFisicaService() {
    }

    public <T> List<T> filter(Map<String, Object> filters, Class<T> clazz) {
        CriteriaBuilder cb = this.genericCrudService.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(clazz);
        Root<T> from = query.from(clazz);
        query.select(from);
        List<Predicate> predicates = new ArrayList();
        Iterator var8 = filters.entrySet().iterator();

        while(var8.hasNext()) {
            Entry<String, Object> filter = (Entry)var8.next();
            Predicate p = cb.equal(from.get((String)filter.getKey()), filter.getValue());
            predicates.add(p);
        }

        Predicate clauses = cb.and((Predicate[])predicates.toArray(new Predicate[predicates.size()]));
        query.where(clauses);
        TypedQuery<T> selectQuery = this.genericCrudService.getEntityManager().createQuery(query);
        return selectQuery.getResultList();
    }

    public SituacaoCadastralPF getSituacaoCadastralAtual(String cpf) {
        StringBuilder query = (new StringBuilder()).append("SELECT s FROM SituacaoCadastralPF s JOIN s.pessoaFisica pf ").append("WHERE pf.nrCpf = :cpf ORDER BY s.dtSituacaoCadastral DESC");
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("cpf", cpf);
        return (SituacaoCadastralPF)this.genericCrudService.findSingleResult(SituacaoCadastralPF.class, query.toString(), paramMap);
    }

    public SituacaoCadastralPF getSituacaoCadastral(String cpf, String hash) {
        StringBuilder query = (new StringBuilder()).append("SELECT s FROM SituacaoCadastralPF s JOIN s.pessoaFisica pf WHERE s.dsHash = :hash AND pf.nrCpf = :cpf");
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("cpf", cpf);
        paramMap.put("hash", hash);
        return (SituacaoCadastralPF)this.genericCrudService.findSingleResult(SituacaoCadastralPF.class, query.toString(), paramMap);
    }

    public PessoaFisica find(int id) {
        return (PessoaFisica)this.genericCrudService.find(PessoaFisica.class, id);
    }

    public boolean exists(int id) {
        return this.genericCrudService.exists(PessoaFisica.class, id);
    }

    public PessoaFisica update(PessoaFisica pessoaFisica) {
        return (PessoaFisica)this.genericCrudService.update(pessoaFisica);
    }

    public PessoaFisica getPessoaFisicaPorCPF(String nrCpf, Servico servico, boolean forcarBuscaNaReceita) throws NegocioException {
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("nrCpf", nrCpf);
        List<PessoaFisica> list = this.genericCrudService.findWithNamedQuery("PessoaFisica.findByCpf", paramMap);
        PessoaFisica pessoa = list.isEmpty() ? null : (PessoaFisica)list.get(0);
        if (pessoa == null) {
            pessoa = this.getPessoaWebServiceReceita(nrCpf, (PessoaFisica)null);
        } else if (forcarBuscaNaReceita) {
            pessoa = this.getPessoaWebServiceReceita(nrCpf, pessoa);
        }

        if (pessoa != null) {
            this.genericCrudService.refresh(pessoa);
            pessoa.getPessoa().setEnderecos(this.enderecoService.getEnderecos(pessoa.getPessoa(), servico));
        }

        return pessoa;
    }

    private PessoaFisica getPessoaWebServiceReceita(String cpf, PessoaFisica pessoaFisicaBaseLocal) throws NegocioException {
        PessoaFisica pessoaFisica = null;

        String message;
        try {
            PessoaUtils.setSSLContextConfiguradoComCertificado();
            ConsultarCPFSoap consultarCPFSoap = new ConsultarCPFSoapProxy();
            message = null;
            PessoaPerfil3[] pessoaReceita;
            if (PessoaUtils.getEstagioProjeto().equalsIgnoreCase("producao")) {
                pessoaReceita = consultarCPFSoap.consultarCPFP3(cpf, CertificateUtil.CPF_CONVENIO_SERPRO);
            } else {
                pessoaReceita = consultarCPFSoap.consultarCPFP3T(cpf, CertificateUtil.CPF_CONVENIO_SERPRO);
            }

            if (pessoaReceita.length > 0) {
                if (ValidacaoUtils.isNotEmpty(pessoaReceita[0].getErro())) {
                    throw new NegocioException(pessoaReceita[0].getErro());
                }

                pessoaFisica = this.converterPessoaFisica(pessoaReceita[0], pessoaFisicaBaseLocal);
                this.cadastrarPessoaFisica(pessoaFisica, pessoaFisicaBaseLocal == null);
            }

            return pessoaFisica;
        } catch (NegocioException var6) {
            throw var6;
        } catch (Exception var7) {
            message = "Erro ao tentar buscar informações na Receita Federal da pessoa de cpf: " + cpf;
            System.err.println(message);
            throw new NegocioException(message);
        }
    }

    private void cadastrarPessoaFisica(PessoaFisica pessoaFisica, boolean isCadastro) throws NegocioException {
        try {
            if (isCadastro) {
                this.genericCrudService.create(pessoaFisica.getPessoa());
                pessoaFisica.setIdPessoaFisica(pessoaFisica.getPessoa().getIdPessoa());
                pessoaFisica.getDocumentacao().setIdPessoaFisica(pessoaFisica.getIdPessoaFisica());
                this.genericCrudService.create(pessoaFisica);
                this.genericCrudService.create(pessoaFisica.getDocumentacao());
            } else {
                this.genericCrudService.update(pessoaFisica);
                this.genericCrudService.update(pessoaFisica.getDocumentacao());
            }

            Iterator var4 = pessoaFisica.getPessoa().getTelefones().iterator();

            while(var4.hasNext()) {
                Telefone tel = (Telefone)var4.next();
                if (tel.getIdTelefone() == 0) {
                    this.genericCrudService.create(tel);
                }
            }

            var4 = pessoaFisica.getPessoa().getEnderecos().iterator();

            while(var4.hasNext()) {
                Endereco end = (Endereco)var4.next();
                if (end.getIdEndereco() == 0) {
                    this.genericCrudService.create(end);
                }
            }

            SituacaoCadastralPF situacaoCadastral = new SituacaoCadastralPF();
            situacaoCadastral.setIdPessoaFisica(pessoaFisica.getIdPessoaFisica());
            situacaoCadastral.setTipoSituacaoCadastral((TipoSituacaoCadastralPF)this.genericCrudService.find(TipoSituacaoCadastralPF.class, Integer.parseInt(pessoaFisica.getTpSituacaoCadastral())));
            situacaoCadastral.setDtSituacaoCadastral(Calendar.getInstance());
            situacaoCadastral.getDtSituacaoCadastral().set(14, 0);
            String hash = PessoaUtils.gerarHashSituacaoCadastral(situacaoCadastral.getIdPessoaFisica(), situacaoCadastral.getDtSituacaoCadastral(), situacaoCadastral.getTipoSituacaoCadastral().getCdSituacaoCadastral());
            situacaoCadastral.setDsHash(hash);
            if (pessoaFisica.getHistoricoSituacaoCadastral() == null) {
                pessoaFisica.setHistoricoSituacaoCadastral(new ArrayList());
            }

            pessoaFisica.getHistoricoSituacaoCadastral().add(situacaoCadastral);
            this.genericCrudService.create(situacaoCadastral);
            this.genericCrudService.getEntityManager().flush();
            this.genericCrudService.getEntityManager().detach(pessoaFisica);
            PessoaFisica var10000 = (PessoaFisica)this.genericCrudService.find(PessoaFisica.class, pessoaFisica.getIdPessoaFisica());
        } catch (Exception var5) {
            var5.printStackTrace();
            throw new NegocioException("Erro ao tentar cadastrar a pessoa de cpf: " + pessoaFisica.getNrCpf());
        }
    }

    private PessoaFisica converterPessoaFisica(PessoaPerfil3 pessoaReceita, PessoaFisica pessoaFisicaBaseLocal) throws NegocioException {
        try {
            Pessoa pessoa = null;
            String pfTipo;
            if (pessoaFisicaBaseLocal != null) {
                pessoa = pessoaFisicaBaseLocal.getPessoa();
            } else {
                pessoa = new Pessoa();
                pfTipo = pessoaReceita.getResidenteExterior();
                TipoAbrangenciaEnum tipoAbrangencia = "1".equalsIgnoreCase(pfTipo) ? TipoAbrangenciaEnum.BRASILEIRO_DOMILICIADO_EXTERIOR : TipoAbrangenciaEnum.BRASILEIRO;
                pessoa.setTipoAbrangencia((TipoAbrangencia)this.genericCrudService.find(TipoAbrangencia.class, tipoAbrangencia.getCodigoAsString()));
                pessoa.setTipoPessoa((TipoPessoa)this.genericCrudService.find(TipoPessoa.class, TipoPessoaEnum.FISICA.getCodigoAsString()));
                pessoa.setPais((Pais)this.genericCrudService.find(Pais.class, PaisEnum.BRASIL.getSigla()));
                pessoa.setDtRegistro(Calendar.getInstance());
            }

            PessoaFisica pf = null;
            if (pessoaFisicaBaseLocal != null) {
                pf = pessoaFisicaBaseLocal;
            } else {
                pf = new PessoaFisica();
                pf.setPessoa(pessoa);
            }

            pf.setNmPessoaFisica(pessoaReceita.getNome());
            pf.setNrCpf(pessoaReceita.getCPF());
            pf.setNmMae(pessoaReceita.getNomeMae());
            pf.setDtNascimento(Calendar.getInstance());
            pf.getDtNascimento().setTime(sdf.parse(pessoaReceita.getDataNascimento()));
            int cdSexo = Integer.parseInt(pessoaReceita.getSexo());
            pf.setSgSexo(cdSexo == 1 ? "M" : (cdSexo == 2 ? "F" : null));
            pf.setTpSituacaoCadastral(pessoaReceita.getSituacaoCadastral());
            pf.setTpResidenteExterior(pessoaReceita.getResidenteExterior());
            if (pessoa.getTelefones() == null) {
                pessoa.setTelefones(new ArrayList());
            }

            if (this.isDadoValido(pessoaReceita.getTelefone())) {
                Telefone telefone = new Telefone();
                telefone.setPessoa(pessoa);
                telefone.setNrTelefone(pessoaReceita.getTelefone());
                telefone.setDdd(new Ddd());
                telefone.getDdd().setCdDdd(Integer.parseInt(pessoaReceita.getDDD()));
                telefone.setTipoTelefone((TipoTelefone)this.genericCrudService.find(TipoTelefone.class, TipoTelefoneEnum.RECEITA_FEDERAL.getCodigo()));
                telefone.setPais(pessoa.getPais());
                if (this.telefoneService.find(telefone) == null) {
                    pessoa.addTelefone(telefone);
                }
            }

            if (pessoa.getEnderecos() == null) {
                pessoa.setEnderecos(new ArrayList());
            }

            if (this.isDadoValido(pessoaReceita.getCEP())) {
                Endereco endereco = new Endereco();
                endereco.setPessoa(pessoa);
                endereco.setTipoEndereco((TipoEndereco)this.genericCrudService.find(TipoEndereco.class, TipoEnderecoEnum.RECEITA_FEDERAL_PF.getCodigo()));
                String cep = pessoaReceita.getCEP();
                endereco.setLogradouro(this.logradouroService.findByCep(cep));
                endereco.setDsComplementoEndereco(pessoaReceita.getComplemento());
                endereco.setNrComplemento(pessoaReceita.getNumeroLogradouro());
                endereco.setDsBairroEndereco(pessoaReceita.getBairro());
                endereco.setServico(new Servico());
                endereco.getServico().setIdServico(PessoaUtils.getIdServicoReceita());
                if (this.enderecoService.find(endereco) == null) {
                    pessoa.addEndereco(endereco);
                }
            }

            if (pf.getDocumentacao() == null) {
                pf.setDocumentacao(new DocumentacaoPessoa());
            }

            pf.getDocumentacao().setNrTituloEleitor(pessoaReceita.getTituloEleitor());
            return pf;
        } catch (Exception var8) {
            var8.printStackTrace();
            throw new NegocioException("Erro ao tentar converter a pessoa de cpf: " + pessoaReceita.getCPF());
        }
    }

    private boolean isDadoValido(String texto) {
        return ValidacaoUtils.isNotEmpty(texto) && !texto.replaceAll("0", "").trim().isEmpty();
    }

    public PessoaFisica getPessoaExecutandoOperacao(HttpServletRequest request) {
        try {
            String cpfUsuario = FormatadorUtils.removerPontosETracos(request.getHeader("cpfUsuario"));
            if (ValidacaoUtils.isCPF(cpfUsuario)) {
                return this.getPessoaFisicaPorCPF(cpfUsuario, (Servico)null, false);
            }
        } catch (Exception var3) {

        }

        return null;
    }

    public boolean isServidor(int idPessoaFisica) {
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("idPessoaFisica", idPessoaFisica);
        StringBuilder builder = (new StringBuilder()).append("SELECT 1 FROM Servidor s WHERE s.pessoaFisica.idPessoaFisica = :idPessoaFisica");
        List<Integer> list = this.genericCrudService.findWithQuery(Integer.class, builder.toString(), paramMap, 0, 1);
        return !list.isEmpty();
    }

    public void isPermitidoAlterar(int idPessoaFisica, Servico servico) throws NegocioException {
        if (this.isServidor(idPessoaFisica) && (servico == null || !PessoaUtils.getNomeServicoRH().equals(servico.getNmServico()))) {
            throw new NegocioException(PessoaUtils.getMsgRhPermissaoAlterar());
        }
    }
}
