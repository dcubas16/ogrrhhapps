package org.ogrrhhapps.dto;


public class RemuneracionDto implements java.io.Serializable{

	private static final long serialVersionUID = 1475297877220808378L;

	private int plaAnu;

	private int plaMes;
	
	private int codTipPla;
	
	private double totalRem;
	
	private double totalDu37;

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

}
