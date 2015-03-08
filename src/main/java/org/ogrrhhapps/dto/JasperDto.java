package org.ogrrhhapps.dto;

import java.io.Serializable;

public class JasperDto implements Serializable{

	private static final long serialVersionUID = 6411259918571811013L;
		
	private int plaAnu;
	
	private int plaMes;
	
	private int totalDu37;
	
	public JasperDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JasperDto(int plaAnu, int plaMes, int totalDu37) {
		super();
		this.plaAnu = plaAnu;
		this.plaMes = plaMes;
		this.totalDu37 = totalDu37;
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
	public int getTotalDu37() {
		return totalDu37;
	}
	public void setTotalDu37(int totalDu37) {
		this.totalDu37 = totalDu37;
	}
	

}
