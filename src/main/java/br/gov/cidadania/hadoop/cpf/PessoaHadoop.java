package br.gov.cidadania.hadoop.cpf;

import java.io.Serializable;
import java.util.Map;

public class PessoaHadoop implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cpf;
	private Map<String, String> atributos;
	
	private static final transient String MASCULINO = "MASCULINO";
	private static final transient String MASCULINO_ABREVIACAO = "M";
	private static final transient String FEMININO_ABREVIACAO = "F";
	private static final transient String RESIDENTE_EXTERIOR = "NAO RESIDENTE";
	private static final transient String RESIDENTE_EXTERIOR_VALOR = "1";
	private static final transient String RESIDENTE_BRASIL_VALOR = "2";
	private static final transient String SITUACAO_REGULAR_VALOR = "0";
	private static final transient String SITUACAO_CANCELADA_ENCERRAMENTO_ESPOLIO = "CANCELADA POR ENCERRAMENTO DE ESPOLIO";
	private static final transient String SITUACAO_CANCELADA_ENCERRAMENTO_ESPOLIO_VALOR = "1";
	private static final transient String SITUACAO_SUSPENSA = "SUSPENSA";
	private static final transient String SITUACAO_SUSPENSA_VALOR = "2";
	private static final transient String SITUACAO_CANCELADA_OBITO_SEM_ESPOLIO = "CANCELADA POR OBITO SEM ESPOLIO";
	private static final transient String SITUACAO_CANCELADA_OBITO_SEM_ESPOLIO_VALOR = "3";
	private static final transient String SITUACAO_PENDENTE_REGULARIZACAO = "PENDENTEDE REGULARIZACAO";
	private static final transient String SITUACAO_PENDENTE_REGULARIZACAO_VALOR = "4";
	private static final transient String SITUACAO_CANCELADA_MULTIPLICIDADE = "CANCELADA POR MULTIPLICIDADE";
	private static final transient String SITUACAO_CANCELADA_MULTIPLICIDADE_VALOR = "5";
	private static final transient String SITUACAO_NULA = "NULA";
	private static final transient String SITUACAO_NULA_VALOR = "6";
	private static final transient String SITUACAO_CANCELADA_OFICIO = "CANCELADA DE OFICIO";
	private static final transient String SITUACAO_CANCELADA_OFICIO_VALOR = "3";
	
	public PessoaHadoop(String cpf, Map<String, String> atributos) {
		this.cpf = cpf;
		this.atributos = atributos;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Map<String, String> getAtributos() {
		return atributos;
	}

	public void setAtributos(Map<String, String> atributos) {
		this.atributos = atributos;
	}
	
	public String getNomePessoa() {
		return this.atributos.get("f:no_pessoa");
	}
	
	public String getNomeMaePessoa() {
		return this.atributos.get("f:no_mae_pessoa");
	}
	
	public String getDataNascimento() {
		return this.atributos.get("f:dt_nascimento");
	}
	
	public String getGenero() {
		String genero = MASCULINO_ABREVIACAO;
		if(!MASCULINO.equalsIgnoreCase(this.atributos.get("f:st_sexo"))) {
			genero = FEMININO_ABREVIACAO;
		}
		return genero;
	}
	
	public String getSituacaoCadastral() {
		String situacao = SITUACAO_REGULAR_VALOR;
		
		switch (this.atributos.get("f:tp_situacao_cadastro")) {
		case SITUACAO_CANCELADA_ENCERRAMENTO_ESPOLIO:
			situacao = SITUACAO_CANCELADA_ENCERRAMENTO_ESPOLIO_VALOR;
			break;
		case SITUACAO_SUSPENSA:
			situacao = SITUACAO_SUSPENSA_VALOR;
			break;
		case SITUACAO_CANCELADA_OBITO_SEM_ESPOLIO:
			situacao = SITUACAO_CANCELADA_OBITO_SEM_ESPOLIO_VALOR;
			break;
		case SITUACAO_PENDENTE_REGULARIZACAO:
			situacao = SITUACAO_PENDENTE_REGULARIZACAO_VALOR;
			break;
		case SITUACAO_CANCELADA_MULTIPLICIDADE:
			situacao = SITUACAO_CANCELADA_MULTIPLICIDADE_VALOR;
			break;
		case SITUACAO_NULA:
			situacao = SITUACAO_NULA_VALOR;
			break;
		case SITUACAO_CANCELADA_OFICIO:
			situacao = SITUACAO_CANCELADA_OFICIO_VALOR;
			break;
		default:
			break;
		}
		
		return situacao;
	}
	
	public String getResidenteExterior() {
		String local = RESIDENTE_EXTERIOR_VALOR;
		if(RESIDENTE_EXTERIOR.equalsIgnoreCase(this.atributos.get("f:st_residente_exterior"))) {
			local = RESIDENTE_BRASIL_VALOR;
		}
		return local;
	}
	
	public String getTelefoneCompleto() {
		return this.atributos.get("f:nu_tel");
	}
	
	public String getTelefone() {
		return this.atributos.get("f:nu_tel").substring(3);
	}
	
	public String getDDD() {
		return this.atributos.get("f:nu_tel").substring(0, 2);
	}
	
	public String getCep() {
		return this.atributos.get("f:nu_cep");
	}
	
	public String getComplementoEndereco() {
		return this.atributos.get("f:ds_complemento");
	}
	
	public String getNumeroLogradouro() {
		return this.atributos.get("f:ds_num_logradouro");
	}
	
	public String getBairro() {
		return this.atributos.get("f:no_bairro");
	}
	
}
