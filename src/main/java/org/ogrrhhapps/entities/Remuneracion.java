package org.ogrrhhapps.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "remuneraciones", schema ="OGRRHHDB")
public class Remuneracion implements java.io.Serializable{

	private static final long serialVersionUID = 1475297877220808378L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id", unique = true, nullable = false)
	private String id;
	
	@Column(name="ser_doc_id_act")
	private String serDocIdAct;
	
	@Column(name="pla_anu")
	private int plaAnu;
	
	@Column(name="pla_mes")
	private int plaMes;
	
	@Column(name="cod_tip_pla")
	private int codTipPla;
	
	@Column(name="total_rem")
	private double totalRem;
	
	@Column(name="total_du_37")
	private double totalDu37;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ser_cod")
	private ServidorTrabajo servidorTrabajo;
	
}
