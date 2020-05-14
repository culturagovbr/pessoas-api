package br.gov.cidadania.hadoop.cnpj;

import java.io.Serializable;
import java.util.Map;

public class EstabelecimentoHadoop implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	private Map<String, String> atributos;
	private static final transient String SITUACAO_ATIVA_VALOR = "2";
	private static final transient String SITUACAO_NULA = "NULA";
	private static final transient String SITUACAO_NULA_VALOR = "1";
	private static final transient String SITUACAO_SUSPENSA = "SUSPENSA";
	private static final transient String SITUACAO_SUSPENSA_VALOR = "3";
	private static final transient String SITUACAO_INAPTA = "INAPTA";
	private static final transient String SITUACAO_INAPTA_VALOR = "4";
	private static final transient String SITUACAO_BAIXADA = "BAIXADA";
	private static final transient String SITUACAO_BAIXADA_VALOR = "8";
	
	public EstabelecimentoHadoop(String cnpj, Map<String, String> atributos) {
		this.cnpj = cnpj;
		this.atributos = atributos;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Map<String, String> getAtributos() {
		return atributos;
	}

	public void setAtributos(Map<String, String> atributos) {
		this.atributos = atributos;
	}
	
	public String getNomeFantasia() {
		return this.atributos.get("f:nm_fantasia");
	}
	
	public String getTelefoneCompleto_01() {
		return this.atributos.get("f:nu_tel_01");
	}
	
	public String getTelefone_01() {
		return this.atributos.get("f:nu_tel_01").substring(3);
	}
	
	public String getDDD_01() {
		return this.atributos.get("f:nu_tel_01").substring(0, 2);
	}
	
	public String getTelefoneCompleto_02() {
		return this.atributos.get("f:nu_tel_02");
	}
	
	public String getTelefone_02() {
		return this.atributos.get("f:nu_tel_02").substring(3);
	}
	
	public String getDDD_02() {
		return this.atributos.get("f:nu_tel_02").substring(0, 2);
	}
	
	public String getCep() {
		return this.atributos.get("f:nu_cep");
	}
	
	public String getComplementoEndereco() {
		return this.atributos.get("f:nm_complemento");
	}
	
	public String getNumeroLogradouro() {
		return this.atributos.get("f:nu_endereco");
	}
	
	public String getBairro() {
		return this.atributos.get("f:nm_bairro");
	}
	
	public String getEmail() {
		return this.atributos.get("f:nm_email");
	}
	
	public String getCnaePrincipal() {
		return this.atributos.get("f:co_cnae_fiscal");
	}
	
	public String getSituacaoCadastral() {
		String situacao = SITUACAO_ATIVA_VALOR;
		
		switch (this.atributos.get("f:tp_sit_cadastro")) {
		case SITUACAO_NULA:
			situacao = SITUACAO_NULA_VALOR;
			break;
		case SITUACAO_SUSPENSA:
			situacao = SITUACAO_SUSPENSA_VALOR;
			break;
		case SITUACAO_INAPTA:
			situacao = SITUACAO_INAPTA_VALOR;
			break;
		case SITUACAO_BAIXADA:
			situacao = SITUACAO_BAIXADA_VALOR;
			break;		
		default:
			break;
		}
		
		return situacao;
	}
	
}
