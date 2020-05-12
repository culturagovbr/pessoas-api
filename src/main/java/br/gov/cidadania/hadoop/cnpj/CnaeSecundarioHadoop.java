package br.gov.cidadania.hadoop.cnpj;

import java.io.Serializable;
import java.util.Map;

public class CnaeSecundarioHadoop implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	private Map<String, String> atributos;

	public CnaeSecundarioHadoop(String cnpj, Map<String, String> atributos) {
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
	
	public String getCnaeSecundario() {
		return this.atributos.get("f:nu_cnae_secundaria");
	}
	
}
