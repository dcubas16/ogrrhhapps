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
@Table(name = "TB37_remuneraciones", schema ="DATAPERSUEL")
public class Remuneracion implements java.io.Serializable{

	private static final long serialVersionUID = 1475297877220808378L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id", unique = true, nullable = false)
	private int id;
	
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


	public Remuneracion(int id, String serDocIdAct, int plaAnu, int plaMes,
			int codTipPla, double totalRem, double totalDu37) {
		super();
		this.id = id;
		this.serDocIdAct = serDocIdAct;
		this.plaAnu = plaAnu;
		this.plaMes = plaMes;
		this.codTipPla = codTipPla;
		this.totalRem = totalRem;
		this.totalDu37 = totalDu37;
	}

	public Remuneracion(String serDocIdAct, int plaAnu, int plaMes,
			int codTipPla, double totalRem, double totalDu37) {
		super();
		this.serDocIdAct = serDocIdAct;
		this.plaAnu = plaAnu;
		this.plaMes = plaMes;
		this.codTipPla = codTipPla;
		this.totalRem = totalRem;
		this.totalDu37 = totalDu37;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSerDocIdAct() {
		return serDocIdAct;
	}

	public void setSerDocIdAct(String serDocIdAct) {
		this.serDocIdAct = serDocIdAct;
	}

	public int getPlaAnu() {
		return plaAnu;
	}

	public void setPlaAnu(int plaAnu) {
		this.plaAnu = plaAnu;
	}

	public int getPlaMes() {
		return plaMes;
	}

	public void setPlaMes(int plaMes) {
		this.plaMes = plaMes;
	}

	public int getCodTipPla() {
		return codTipPla;
	}

	public void setCodTipPla(int codTipPla) {
		this.codTipPla = codTipPla;
	}

	public double getTotalRem() {
		return totalRem;
	}

	public void setTotalRem(double totalRem) {
		this.totalRem = totalRem;
	}

	public double getTotalDu37() {
		return totalDu37;
	}

	public void setTotalDu37(double totalDu37) {
		this.totalDu37 = totalDu37;
	}

	public ServidorTrabajo getServidorTrabajo() {
		return servidorTrabajo;
	}

	public void setServidorTrabajo(ServidorTrabajo servidorTrabajo) {
		this.servidorTrabajo = servidorTrabajo;
	}
	
}
