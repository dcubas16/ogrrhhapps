package org.ogrrhhapps.dto;

import java.io.Serializable;

public class RemuneracionPorMesesDto implements Serializable {

	private static final long serialVersionUID = 3980570052033786769L;

	private int plaAnu;
	
	private double duEnero;
	
	private double duFebrero;
	
	private double duMarzo;
	
	private double duAbril;
	
	private double duMayo;
	
	private double duJunio;
	
	private double duJulio;
	
	private double duAgosto;
	
	private double duSetiembre;
	
	private double duOctubre;
	
	private double duNoviembre;
	
	private double duDiciembre;
	
	public RemuneracionPorMesesDto(int plaAnu, double duEnero,
			double duFebrero, double duMarzo, double duAbril, double duMayo,
			double duJunio, double duJulio, double duAgosto,
			double duSetiembre, double duOctubre, double duNoviembre,
			double duDiciembre) {
		super();
		this.plaAnu = plaAnu;
		this.duEnero = duEnero;
		this.duFebrero = duFebrero;
		this.duMarzo = duMarzo;
		this.duAbril = duAbril;
		this.duMayo = duMayo;
		this.duJunio = duJunio;
		this.duJulio = duJulio;
		this.duAgosto = duAgosto;
		this.duSetiembre = duSetiembre;
		this.duOctubre = duOctubre;
		this.duNoviembre = duNoviembre;
		this.duDiciembre = duDiciembre;
	}
	
	public RemuneracionPorMesesDto() {
		// TODO Auto-generated constructor stub
	}

	public RemuneracionPorMesesDto(int plaAnu) {
		super();
		this.plaAnu = plaAnu;
	}

	public int getPlaAnu() {
		return plaAnu;
	}
	public void setPlaAnu(int plaAnu) {
		this.plaAnu = plaAnu;
	}
	public double getDuEnero() {
		return duEnero;
	}
	public void setDuEnero(double duEnero) {
		this.duEnero = duEnero;
	}
	public double getDuFebrero() {
		return duFebrero;
	}
	public void setDuFebrero(double duFebrero) {
		this.duFebrero = duFebrero;
	}
	public double getDuMarzo() {
		return duMarzo;
	}
	public void setDuMarzo(double duMarzo) {
		this.duMarzo = duMarzo;
	}
	public double getDuAbril() {
		return duAbril;
	}
	public void setDuAbril(double duAbril) {
		this.duAbril = duAbril;
	}
	public double getDuMayo() {
		return duMayo;
	}
	public void setDuMayo(double duMayo) {
		this.duMayo = duMayo;
	}
	public double getDuJunio() {
		return duJunio;
	}
	public void setDuJunio(double duJunio) {
		this.duJunio = duJunio;
	}
	public double getDuJulio() {
		return duJulio;
	}
	public void setDuJulio(double duJulio) {
		this.duJulio = duJulio;
	}
	public double getDuAgosto() {
		return duAgosto;
	}
	public void setDuAgosto(double duAgosto) {
		this.duAgosto = duAgosto;
	}
	public double getDuSetiembre() {
		return duSetiembre;
	}
	public void setDuSetiembre(double duSetiembre) {
		this.duSetiembre = duSetiembre;
	}
	public double getDuOctubre() {
		return duOctubre;
	}
	public void setDuOctubre(double duOctubre) {
		this.duOctubre = duOctubre;
	}
	public double getDuNoviembre() {
		return duNoviembre;
	}
	public void setDuNoviembre(double duNoviembre) {
		this.duNoviembre = duNoviembre;
	}
	public double getDuDiciembre() {
		return duDiciembre;
	}
	public void setDuDiciembre(double duDiciembre) {
		this.duDiciembre = duDiciembre;
	}
}
