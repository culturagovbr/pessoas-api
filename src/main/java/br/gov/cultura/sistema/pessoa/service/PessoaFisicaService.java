package br.gov.cultura.sistema.pessoa.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.gov.cidadania.hadoop.cpf.PessoaHadoop;
import br.gov.cidadania.hadoop.cpf.PessoaHadoopDTODeserializer;
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

@Stateless
public class PessoaFisicaService {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
            pessoa = this.getPessoaHadoop(nrCpf, (PessoaFisica)null);
        } else if (forcarBuscaNaReceita) {
            pessoa = this.getPessoaHadoop(nrCpf, pessoa);
        }

        if (pessoa == null) {
        	throw new NegocioException(PessoaUtils.getMsgPessoaFisicaNaoEncontradada());
        } else {
        	this.genericCrudService.refresh(pessoa);
            pessoa.getPessoa().setEnderecos(this.enderecoService.getEnderecos(pessoa.getPessoa(), servico));
        }

        return pessoa;
    }

    private PessoaFisica getPessoaHadoop(String cpf, PessoaFisica pessoaFisicaBaseLocal) throws NegocioException {
        
    	PessoaFisica pessoaFisica = null;
        String message = null;
        
        try {
			
        	StringBuffer buffer = requisicao(cpf);
			
			final Gson gson = new GsonBuilder().registerTypeAdapter(PessoaHadoop.class, new PessoaHadoopDTODeserializer()).create();
			PessoaHadoop pessoaHadoop = gson.fromJson(buffer.toString(), PessoaHadoop.class);
			
			if(pessoaHadoop != null) {
				pessoaFisica = this.converterPessoaFisica(pessoaHadoop, pessoaFisicaBaseLocal);
				this.cadastrarPessoaFisica(pessoaFisica, pessoaFisicaBaseLocal == null);
			}
			
        } catch (NegocioException e) {            
            throw new NegocioException(e.getMessage());        	
        }catch (Exception var7) {
            message = "Erro ao tentar buscar informações na Receita Federal da pessoa de cpf: " + cpf;
            System.err.println(message);
            throw new NegocioException(message);        	
        }
		return pessoaFisica;
    }

	private StringBuffer requisicao(String cpf) throws IOException, ClientProtocolException {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet("http://tdhdp01en01.mds.net:8099/p_hbase.tb_cpf/" + cpf);
		request.addHeader("Accept", "application/json");
		HttpResponse response = client.execute(request);
		
		final BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String inputLine;
		StringBuffer buffer = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			buffer.append(inputLine);
		}
		in.close();
		return buffer;
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

    private PessoaFisica converterPessoaFisica(PessoaHadoop pessoahadoop, PessoaFisica pessoaFisicaBaseLocal) throws NegocioException {
        try {
            Pessoa pessoa = null;
            String pfTipo;
            if (pessoaFisicaBaseLocal != null) {
                pessoa = pessoaFisicaBaseLocal.getPessoa();
            } else {
                pessoa = new Pessoa();
                pfTipo = pessoahadoop.getResidenteExterior();
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

            pf.setNmPessoaFisica(pessoahadoop.getNomePessoa());
            pf.setNrCpf(pessoahadoop.getCpf());
            pf.setNmMae(pessoahadoop.getNomeMaePessoa());
            pf.setDtNascimento(Calendar.getInstance());
            pf.getDtNascimento().setTime(sdf.parse(pessoahadoop.getDataNascimento()));
            pf.setSgSexo(pessoahadoop.getGenero());
            pf.setTpSituacaoCadastral(pessoahadoop.getSituacaoCadastral());
            pf.setTpResidenteExterior(pessoahadoop.getResidenteExterior());
            if (pessoa.getTelefones() == null) {
                pessoa.setTelefones(new ArrayList());
            }

            if (this.isDadoValido(pessoahadoop.getTelefoneCompleto())) {
                Telefone telefone = new Telefone();
                telefone.setPessoa(pessoa);
                telefone.setNrTelefone(pessoahadoop.getTelefone());
                telefone.setDdd(new Ddd());
                telefone.getDdd().setCdDdd(Integer.parseInt(pessoahadoop.getDDD()));
                telefone.setTipoTelefone((TipoTelefone)this.genericCrudService.find(TipoTelefone.class, TipoTelefoneEnum.RECEITA_FEDERAL.getCodigo()));
                telefone.setPais(pessoa.getPais());
                if (this.telefoneService.find(telefone) == null) {
                    pessoa.addTelefone(telefone);
                }
            }

            if (pessoa.getEnderecos() == null) {
                pessoa.setEnderecos(new ArrayList());
            }

            if (this.isDadoValido(pessoahadoop.getCep())) {
                Endereco endereco = new Endereco();
                endereco.setPessoa(pessoa);
                endereco.setTipoEndereco((TipoEndereco)this.genericCrudService.find(TipoEndereco.class, TipoEnderecoEnum.RECEITA_FEDERAL_PF.getCodigo()));
                String cep = pessoahadoop.getCep();
                endereco.setLogradouro(this.logradouroService.findByCep(cep));
                endereco.setDsComplementoEndereco(pessoahadoop.getComplementoEndereco());
                endereco.setNrComplemento(pessoahadoop.getNumeroLogradouro());
                endereco.setDsBairroEndereco(pessoahadoop.getBairro());
                endereco.setServico(new Servico());
                endereco.getServico().setIdServico(PessoaUtils.getIdServicoReceita());
                if (this.enderecoService.find(endereco) == null) {
                    pessoa.addEndereco(endereco);
                }
            }

            if (pf.getDocumentacao() == null) {
                pf.setDocumentacao(new DocumentacaoPessoa());
            }
            
            return pf;
        } catch (Exception var8) {
            var8.printStackTrace();
            throw new NegocioException("Erro ao tentar converter a pessoa de cpf: " + pessoahadoop.getCpf());
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
