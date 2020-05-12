package br.gov.cidadania.hadoop.cnpj;

import java.io.Serializable;
import java.util.Map;

public class EmpresaHadoop implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	private Map<String, String> atributos;

	public EmpresaHadoop(String cnpj, Map<String, String> atributos) {
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
	
	public String getNomeEmpresarial() {
		return this.atributos.get("f:nm_empresarial");
	}
	
	public String getCodigoNaturezaJuridica() {
		return this.atributos.get("f:co_natureza_juridica");
	}
	
}
