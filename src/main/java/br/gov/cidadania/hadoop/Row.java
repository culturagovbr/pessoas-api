package br.gov.cidadania.hadoop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Row implements Serializable {

	@SerializedName("key")
	@Expose
	private String key;
	@SerializedName("Cell")
	@Expose
	private List<Cell> cell = new ArrayList<Cell>();
	private final static long serialVersionUID = 7918043526773872940L;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Row withKey(String key) {
		this.key = key;
		return this;
	}

	public List<Cell> getCell() {
		return cell;
	}

	public void setCell(List<Cell> cell) {
		this.cell = cell;
	}

	public Row withCell(List<Cell> cell) {
		this.cell = cell;
		return this;
	}

}
