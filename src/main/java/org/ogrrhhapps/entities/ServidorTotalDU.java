package org.ogrrhhapps.entities;

import org.codehaus.jackson.annotate.JsonProperty;


public class ServidorTotalDU {

	@JsonProperty
	private String serDocIdAct;
	@JsonProperty
	private String serApePat;
	@JsonProperty
	private String serApeMat;
	@JsonProperty
	private String serNombres;
	@JsonProperty
	private double totalDu37;

	public ServidorTotalDU(String serDocIdAct, String serApePat,
			String serApeMat, String serNombres, double totalDu37) {
		super();
		this.serDocIdAct = serDocIdAct;
		this.serApePat = serApePat;
		this.serApeMat = serApeMat;
		this.serNombres = serNombres;
		this.totalDu37 = totalDu37;
	}

	public String getSerDocIdAct() {
		return serDocIdAct;
	}

	public void setSerDocIdAct(String serDocIdAct) {
		this.serDocIdAct = serDocIdAct;
	}

	public String getSerApePat() {
		return serApePat;
	}

	public void setSerApePat(String serApePat) {
		this.serApePat = serApePat;
	}

	public String getSerApeMat() {
		return serApeMat;
	}

	public void setSerApeMat(String serApeMat) {
		this.serApeMat = serApeMat;
	}

	public String getSerNombres() {
		return serNombres;
	}

	public void setSerNombres(String serNombres) {
		this.serNombres = serNombres;
	}

	public double getTotalDu37() {
		return totalDu37;
	}

	public void setTotalDu37(double totalDu37) {
		this.totalDu37 = totalDu37;
	}

	
}
