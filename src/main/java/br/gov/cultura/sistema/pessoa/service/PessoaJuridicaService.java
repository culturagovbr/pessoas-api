package br.gov.cultura.sistema.pessoa.service;

import br.gov.cultura.sistema.model.corporativo.Ddd;
import br.gov.cultura.sistema.model.corporativo.Email;
import br.gov.cultura.sistema.model.corporativo.Endereco;
import br.gov.cultura.sistema.model.corporativo.NaturezaJuridica;
import br.gov.cultura.sistema.model.corporativo.Pais;
import br.gov.cultura.sistema.model.corporativo.Pessoa;
import br.gov.cultura.sistema.model.corporativo.PessoaJuridica;
import br.gov.cultura.sistema.model.corporativo.PessoaJuridicaCnae;
import br.gov.cultura.sistema.model.corporativo.SituacaoCadastralPJ;
import br.gov.cultura.sistema.model.corporativo.Telefone;
import br.gov.cultura.sistema.model.corporativo.TipoAbrangencia;
import br.gov.cultura.sistema.model.corporativo.TipoEmail;
import br.gov.cultura.sistema.model.corporativo.TipoEndereco;
import br.gov.cultura.sistema.model.corporativo.TipoPessoa;
import br.gov.cultura.sistema.model.corporativo.TipoSituacaoCadastralPJ;
import br.gov.cultura.sistema.model.corporativo.TipoTelefone;
import br.gov.cultura.sistema.model.enums.BooleanEnum;
import br.gov.cultura.sistema.model.enums.corporativo.PaisEnum;
import br.gov.cultura.sistema.model.enums.corporativo.TipoAbrangenciaEnum;
import br.gov.cultura.sistema.model.enums.corporativo.TipoEmailEnum;
import br.gov.cultura.sistema.model.enums.corporativo.TipoEnderecoEnum;
import br.gov.cultura.sistema.model.enums.corporativo.TipoPessoaEnum;
import br.gov.cultura.sistema.model.enums.corporativo.TipoTelefoneEnum;
import br.gov.cultura.sistema.model.seguranca.Servico;
import br.gov.cultura.sistema.pessoa.PessoaUtils;
import br.gov.cultura.sistema.pessoa.exception.NegocioException;
import br.gov.cultura.sistema.service.GenericCrudService;
import br.gov.cultura.sistema.util.ValidacaoUtils;
import br.gov.fazenda.receita.infoconv.ws.cnpj.CNPJPerfil3;
import br.gov.fazenda.receita.infoconv.ws.cnpj.ConsultarCNPJSoap;
import br.gov.fazenda.receita.infoconv.ws.cnpj.ConsultarCNPJSoapProxy;
import br.gov.fazenda.receita.infoconv.ws.util.CertificateUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

@Stateless
public class PessoaJuridicaService {
    @Inject
    private GenericCrudService genericCrudService;
    @Inject
    private EnderecoService enderecoService;
    @Inject
    private TelefoneService telefoneService;
    @Inject
    private EmailService emailService;
    @Inject
    private LogradouroService logradouroService;
    @Inject
    private CnaeService cnaeService;

    public PessoaJuridicaService() {
    }

    public PessoaJuridica find(int id) {
        return (PessoaJuridica)this.genericCrudService.find(PessoaJuridica.class, id);
    }

    public SituacaoCadastralPJ getSituacaoCadastralAtual(String cnpj) {
        StringBuilder query = (new StringBuilder()).append("SELECT s FROM SituacaoCadastralPJ s JOIN s.pessoaJuridica pj ").append("WHERE pj.nrCnpj = :cnpj ORDER BY s.dtSituacaoCadastral DESC");
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("cnpj", cnpj);
        return (SituacaoCadastralPJ)this.genericCrudService.findSingleResult(SituacaoCadastralPJ.class, query.toString(), paramMap);
    }

    public SituacaoCadastralPJ getSituacaoCadastral(String cnpj, String hash) {
        StringBuilder query = (new StringBuilder()).append("SELECT s FROM SituacaoCadastralPJ s JOIN s.pessoaJuridica pj WHERE s.dsHash = :hash AND pj.nrCnpj = :cnpj");
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("cnpj", cnpj);
        paramMap.put("hash", hash);
        return (SituacaoCadastralPJ)this.genericCrudService.findSingleResult(SituacaoCadastralPJ.class, query.toString(), paramMap);
    }

    public PessoaJuridica getPessoaJuridicaPorCNPJ(String nrCnpj, Servico servico, boolean forcarBuscaNaReceita) throws NegocioException {
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("nrCnpj", nrCnpj);
        List<PessoaJuridica> list = this.genericCrudService.findWithNamedQuery("PessoaJuridica.findByCnpj", paramMap);
        PessoaJuridica pessoa = list.isEmpty() ? null : (PessoaJuridica)list.get(0);
        if (pessoa == null) {
            pessoa = this.getPessoaJuridicaWebServiceReceita(nrCnpj, (PessoaJuridica)null);
        } else if (forcarBuscaNaReceita) {
            pessoa = this.getPessoaJuridicaWebServiceReceita(nrCnpj, pessoa);
        }

        if (pessoa != null) {
            this.genericCrudService.refresh(pessoa);
            pessoa.getPessoa().setEnderecos(this.enderecoService.getEnderecos(pessoa.getPessoa(), servico));
        }

        return pessoa;
    }

    private PessoaJuridica getPessoaJuridicaWebServiceReceita(String cnpj, PessoaJuridica pessoaJuridicaBaseLocal) throws NegocioException {
        PessoaJuridica pessoaJuridica = null;

        try {
            PessoaUtils.setSSLContextConfiguradoComCertificado();
            ConsultarCNPJSoap consultarCNPJSoap = new ConsultarCNPJSoapProxy();
            CNPJPerfil3[] pessoaReceita = null;
            if (PessoaUtils.getEstagioProjeto().equalsIgnoreCase("producao")) {
                pessoaReceita = consultarCNPJSoap.consultarCNPJP3(cnpj, CertificateUtil.CPF_CONVENIO_SERPRO);
            } else {
                pessoaReceita = consultarCNPJSoap.consultarCNPJP3T(cnpj, CertificateUtil.CPF_CONVENIO_SERPRO);
            }

            if (pessoaReceita.length > 0) {
                pessoaJuridica = this.converterPessoaJuridica(pessoaReceita[0], pessoaJuridicaBaseLocal);
                this.cadastrarPessoaJuridica(pessoaJuridica, pessoaJuridicaBaseLocal == null, Integer.parseInt(pessoaReceita[0].getSituacaoCadastral()));
            }
        } catch (NegocioException var6) {
            throw var6;
        } catch (Exception var7) {
            System.err.println("Erro ao tentar buscar informações na Receita Federal da empresa de cnpj: " + cnpj);
        }

        return pessoaJuridica;
    }

    private void cadastrarPessoaJuridica(PessoaJuridica pessoaJuridica, boolean isCadastro, int codSituacaoCadastral) throws NegocioException {
        try {
            List<PessoaJuridicaCnae> cnaes = new ArrayList(pessoaJuridica.getCnaes());
            Telefone telefone;
            Iterator var6;
            if (isCadastro) {
                this.genericCrudService.create(pessoaJuridica.getPessoa());
                pessoaJuridica.setIdPessoaJuridica(pessoaJuridica.getPessoa().getIdPessoa());
                this.genericCrudService.create(pessoaJuridica);
                if (ValidacaoUtils.isNotEmpty(pessoaJuridica.getPessoa().getEmails())) {
                    ((Email)pessoaJuridica.getPessoa().getEmails().get(0)).setIdPessoa(pessoaJuridica.getIdPessoaJuridica());
                    this.genericCrudService.create((Email)pessoaJuridica.getPessoa().getEmails().get(0));
                }

                if (ValidacaoUtils.isNotEmpty(pessoaJuridica.getPessoa().getTelefones())) {
                    var6 = pessoaJuridica.getPessoa().getTelefones().iterator();

                    while(var6.hasNext()) {
                        telefone = (Telefone)var6.next();
                        this.genericCrudService.create(telefone);
                    }
                }

                if (ValidacaoUtils.isNotEmpty(pessoaJuridica.getPessoa().getEnderecos())) {
                    this.genericCrudService.create((Endereco)pessoaJuridica.getPessoa().getEnderecos().get(0));
                }
            } else {
                this.genericCrudService.update(pessoaJuridica);
                var6 = pessoaJuridica.getPessoa().getTelefones().iterator();

                while(var6.hasNext()) {
                    telefone = (Telefone)var6.next();
                    if (telefone.getIdTelefone() == 0) {
                        this.genericCrudService.create(telefone);
                    }
                }

                var6 = pessoaJuridica.getPessoa().getEnderecos().iterator();

                while(var6.hasNext()) {
                    Endereco end = (Endereco)var6.next();
                    if (end.getIdEndereco() == 0) {
                        this.genericCrudService.create(end);
                    }
                }

                var6 = pessoaJuridica.getPessoa().getEmails().iterator();

                while(var6.hasNext()) {
                    Email email = (Email)var6.next();
                    if (email.getIdEmail() == 0) {
                        email.setIdPessoa(pessoaJuridica.getIdPessoaJuridica());
                        this.genericCrudService.create(email);
                    }
                }
            }

            if (ValidacaoUtils.isNotEmpty(cnaes)) {
                var6 = cnaes.iterator();

                while(var6.hasNext()) {
                    PessoaJuridicaCnae cnae = (PessoaJuridicaCnae)var6.next();
                    this.genericCrudService.create(cnae);
                }
            }

            SituacaoCadastralPJ situacaoCadastral = new SituacaoCadastralPJ();
            situacaoCadastral.setIdPessoaJuridica(pessoaJuridica.getIdPessoaJuridica());
            situacaoCadastral.setTipoSituacaoCadastral((TipoSituacaoCadastralPJ)this.genericCrudService.find(TipoSituacaoCadastralPJ.class, codSituacaoCadastral));
            situacaoCadastral.setDtSituacaoCadastral(Calendar.getInstance());
            situacaoCadastral.getDtSituacaoCadastral().set(14, 0);
            String hash = PessoaUtils.gerarHashSituacaoCadastral(situacaoCadastral.getIdPessoaJuridica(), situacaoCadastral.getDtSituacaoCadastral(), situacaoCadastral.getTipoSituacaoCadastral().getCdSituacaoCadastral());
            situacaoCadastral.setDsHash(hash);
            pessoaJuridica.setHistoricoSituacaoCadastral(new ArrayList());
            pessoaJuridica.getHistoricoSituacaoCadastral().add(situacaoCadastral);
            this.genericCrudService.create(situacaoCadastral);
            this.genericCrudService.getEntityManager().flush();
            this.genericCrudService.getEntityManager().detach(pessoaJuridica);
            PessoaJuridica var10000 = (PessoaJuridica)this.genericCrudService.find(PessoaJuridica.class, pessoaJuridica.getIdPessoaJuridica());
        } catch (Exception var7) {
            throw new NegocioException("Erro ao tentar cadastrar a empresa de cnpj: " + pessoaJuridica.getNrCnpj());
        }
    }

    private PessoaJuridica converterPessoaJuridica(CNPJPerfil3 pessoaReceita, PessoaJuridica pessoaJuridicaBaseLocal) throws NegocioException {
        try {
            Pessoa pessoa = null;
            if (pessoaJuridicaBaseLocal != null) {
                pessoa = pessoaJuridicaBaseLocal.getPessoa();
            } else {
                pessoa = new Pessoa();
                pessoa.setTipoAbrangencia((TipoAbrangencia)this.genericCrudService.find(TipoAbrangencia.class, TipoAbrangenciaEnum.BRASILEIRO.getCodigoAsString()));
                pessoa.setTipoPessoa((TipoPessoa)this.genericCrudService.find(TipoPessoa.class, TipoPessoaEnum.JURIDICA.getCodigoAsString()));
                pessoa.setPais((Pais)this.genericCrudService.find(Pais.class, PaisEnum.BRASIL.getSigla()));
                pessoa.setDtRegistro(Calendar.getInstance());
            }

            PessoaJuridica pj = null;
            if (pessoaJuridicaBaseLocal != null) {
                pj = pessoaJuridicaBaseLocal;
            } else {
                pj = new PessoaJuridica();
                pj.setPessoa(pessoa);
            }

            pj.setNrCnpj(pessoaReceita.getCNPJ());
            pj.setNmFantasia(pessoaReceita.getNomeFantasia());
            pj.setNmRazaoSocial(pessoaReceita.getNomeEmpresarial());
            NaturezaJuridica naturezaJuridica = (NaturezaJuridica)this.genericCrudService.find(NaturezaJuridica.class, pessoaReceita.getNaturezaJuridica());
            if (naturezaJuridica != null) {
                pj.setNaturezaJuridica(naturezaJuridica);
            }

            if (pessoa.getTelefones() == null) {
                pessoa.setTelefones(new ArrayList());
            }

            Telefone telefone2;
            if (this.isDadoValido(pessoaReceita.getTelefone1())) {
                telefone2 = new Telefone();
                telefone2.setPessoa(pessoa);
                telefone2.setNrTelefone(pessoaReceita.getTelefone1());
                telefone2.setDdd(new Ddd());
                telefone2.getDdd().setCdDdd(Integer.parseInt(pessoaReceita.getDDD1()));
                telefone2.setTipoTelefone((TipoTelefone)this.genericCrudService.find(TipoTelefone.class, TipoTelefoneEnum.RECEITA_FEDERAL.getCodigo()));
                telefone2.setPais(pessoa.getPais());
                if (this.telefoneService.find(telefone2) == null) {
                    pessoa.addTelefone(telefone2);
                }
            }

            if (this.isDadoValido(pessoaReceita.getTelefone2())) {
                telefone2 = new Telefone();
                telefone2.setPessoa(pessoa);
                telefone2.setNrTelefone(pessoaReceita.getTelefone2());
                telefone2.setDdd(new Ddd());
                telefone2.getDdd().setCdDdd(Integer.parseInt(pessoaReceita.getDDD2()));
                telefone2.setTipoTelefone((TipoTelefone)this.genericCrudService.find(TipoTelefone.class, TipoTelefoneEnum.RECEITA_FEDERAL.getCodigo()));
                telefone2.setPais(pessoa.getPais());
                if (this.telefoneService.find(telefone2) == null) {
                    pessoa.addTelefone(telefone2);
                }
            }

            if (pessoa.getEnderecos() == null) {
                pessoa.setEnderecos(new ArrayList());
            }

            String codCnae;
            if (this.isDadoValido(pessoaReceita.getCEP())) {
                Endereco endereco = new Endereco();
                endereco.setPessoa(pessoa);
                endereco.setTipoEndereco((TipoEndereco)this.genericCrudService.find(TipoEndereco.class, TipoEnderecoEnum.RECEITA_FEDERAL_PJ.getCodigo()));
                codCnae = pessoaReceita.getCEP();
                endereco.setLogradouro(this.logradouroService.findByCep(codCnae));
                endereco.setDsComplementoEndereco(pessoaReceita.getComplemento());
                endereco.setNrComplemento(pessoaReceita.getNumeroLogradouro());
                endereco.setDsBairroEndereco(pessoaReceita.getBairro());
                endereco.setServico(new Servico());
                endereco.getServico().setIdServico(PessoaUtils.getIdServicoReceita());
                if (this.enderecoService.find(endereco) == null) {
                    pessoa.addEndereco(endereco);
                }
            }

            if (pessoa.getEmails() == null) {
                pessoa.setEmails(new ArrayList());
            }

            if (this.isDadoValido(pessoaReceita.getEmail())) {
                Email email = new Email();
                email.setPessoa(pessoa);
                email.setDsEmail(pessoaReceita.getEmail());
                email.setStEmailPrincipal(BooleanEnum.SIM.getSigla());
                email.setTipoEmail((TipoEmail)this.genericCrudService.find(TipoEmail.class, TipoEmailEnum.COMERCIAL.getCodigo()));
                if (this.emailService.find(email) == null) {
                    pessoa.addEmail(email);
                }
            }

            this.excluirCNAEsEmpresa(pj);
            pj.setCnaes(new ArrayList());
            PessoaJuridicaCnae cnae = new PessoaJuridicaCnae();
            cnae.setCnae(this.cnaeService.pesquisarPorCodigo(pessoaReceita.getCNAEPrincipal()));
            if (cnae.getCnae() != null) {
                cnae.setPessoaJuridica(pj);
                cnae.setStCnae("P");
                pj.getCnaes().add(cnae);
                if (pessoaReceita.getCNAESecundario() != null) {
                    String[] var10;
                    int var9 = (var10 = pessoaReceita.getCNAESecundario()).length;

                    for(int var8 = 0; var8 < var9; ++var8) {
                        codCnae = var10[var8];
                        if (!"0000000".equals(codCnae)) {
                            PessoaJuridicaCnae cnaeSec = new PessoaJuridicaCnae();
                            cnaeSec.setCnae(this.cnaeService.pesquisarPorCodigo(codCnae));
                            if (cnaeSec.getCnae() != null) {
                                cnaeSec.setPessoaJuridica(pj);
                                cnaeSec.setStCnae("S");
                                pj.getCnaes().add(cnaeSec);
                            }
                        }
                    }
                }
            }

            return pj;
        } catch (Exception var12) {
            throw new NegocioException("Erro ao tentar converter a empresa de cnpj: " + pessoaReceita.getCNPJ());
        }
    }

    private boolean isDadoValido(String texto) {
        return ValidacaoUtils.isNotEmpty(texto) && !texto.replaceAll("0", "").trim().isEmpty();
    }

    private void excluirCNAEsEmpresa(PessoaJuridica pj) {
        if (ValidacaoUtils.isNotEmpty(pj.getIdPessoaJuridica())) {
            Query query = this.genericCrudService.getEntityManager().createQuery("DELETE FROM PessoaJuridicaCnae e WHERE e.pessoaJuridica.idPessoaJuridica = :pessoaJuridica");
            query.setParameter("pessoaJuridica", pj.getIdPessoaJuridica());
            query.executeUpdate();
        }

    }
}
