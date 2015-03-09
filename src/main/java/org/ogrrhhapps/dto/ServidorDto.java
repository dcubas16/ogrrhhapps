package org.ogrrhhapps.dto;


public class ServidorDto implements java.io.Serializable {

	private static final long serialVersionUID = 7847775958930666088L;
	
	private String serDocIdAct;

	private String serApePat;
	
	private String serApeMat;
	
	private String serNombres;
	
	public ServidorDto(String serApePat, String serApeMat, String serNombres) {
		super();
		this.serApePat = serApePat;
		this.serApeMat = serApeMat;
		this.serNombres = serNombres;
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
	
}
