package br.gov.cidadania.hadoop;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cell implements Serializable {

	@SerializedName("column")
	@Expose
	private String column;
	@SerializedName("$")
	@Expose
	private String $;
	private final static long serialVersionUID = -2224605396458383884L;

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public Cell withColumn(String column) {
		this.column = column;
		return this;
	}

	public String get$() {
		return $;
	}

	public void set$(String $) {
		this.$ = $;
	}

	public Cell with$(String $) {
		this.$ = $;
		return this;
	}

}
