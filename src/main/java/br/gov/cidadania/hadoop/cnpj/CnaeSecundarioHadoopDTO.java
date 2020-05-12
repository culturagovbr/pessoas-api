package br.gov.cidadania.hadoop.cnpj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import br.gov.cidadania.hadoop.Row;

public class CnaeSecundarioHadoopDTO implements Serializable {

	@SerializedName("Row")
	@Expose
	private List<Row> row = new ArrayList<Row>();
	private final static long serialVersionUID = -3840500479415278922L;

	public List<Row> getRow() {
		return row;
	}

	public void setRow(List<Row> row) {
		this.row = row;
	}

	public CnaeSecundarioHadoopDTO withRow(List<Row> row) {
		this.row = row;
		return this;
	}

}
