package org.ogrrhhapps.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "servidores", schema ="OGRRHHDB")
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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "serCod", cascade=CascadeType.ALL, targetEntity=ServidorTrabajo.class)
	private Set<ServidorTrabajo> servidorTrabajos = new HashSet<ServidorTrabajo>(0);
	
}
