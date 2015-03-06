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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "SERVIDOR_TRABAJO", schema ="OGRRHHDB")
public class ServidorTrabajo implements java.io.Serializable {

	private static final long serialVersionUID = 7847775958930666088L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ser_cod", unique = true, nullable = false)
	private String serCod;
	
//	@Column(name="num_serest")
//	private String numSerEst;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ser_doc_id_act")
	private Servidor servidor;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "servidorTrabajo", cascade=CascadeType.ALL, targetEntity=Remuneracion.class)
	private Set<Remuneracion> remuneraciones = new HashSet<Remuneracion>(0);
	
}
