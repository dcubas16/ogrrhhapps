package org.ogrrhhapps.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "servidores")
public class Servidor implements java.io.Serializable {

	private static final long serialVersionUID = 7847775958930666088L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ser_doc_id_act", unique = true, nullable = false)
	private String serDocIdAct;

	@Column(name="ser_ape_pat")
	private String serApePat;
	
	@Column(name="ser_ape_mat")
	private String serApeMat;
	
	@Column(name="ser_nombres")
	private String serNombres;
	
	public Servidor(String serDocIdAct, String serApePat, String serApeMat,String serNombres) {
		this.serDocIdAct = serDocIdAct;
		this.serApePat =  serApePat;
		this.serApeMat =  serApeMat;
		this.serNombres =  serNombres;
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
