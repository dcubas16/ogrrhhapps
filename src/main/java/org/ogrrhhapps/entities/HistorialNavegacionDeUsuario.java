package org.ogrrhhapps.entities;

import java.util.Date;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "ley_sesion_url")
@AssociationOverrides({
	@AssociationOverride(name = "id_normas", joinColumns = @JoinColumn(name = "id_normas")), 
	@AssociationOverride(name = "id_usuario", joinColumns = @JoinColumn(name = "id_usuario"))})
public class HistorialNavegacionDeUsuario  implements java.io.Serializable{
	private static final long serialVersionUID = -1907823137070830985L;
	
	private HistorialNavegacionDeUsuarioId pk = new HistorialNavegacionDeUsuarioId();
	private Date fecha_acceso;
	
	public HistorialNavegacionDeUsuario(){
	}
	
	@EmbeddedId
	public HistorialNavegacionDeUsuarioId getPk() {
		return pk;
	}
	
	public void setPk(HistorialNavegacionDeUsuarioId pk) {
		this.pk = pk;
	}
	
	@Transient
	public Usuario getUsuario(){
		return getPk().getUsuario();
	}
	
	public void setUsuario(Usuario usuario){
		getPk().setUsuario(usuario);
	}
	
	@Transient
	public LeyNorma getLeyNorma(){
		return getPk().getLeyNorma();
	}
	
	public void setLeyNorma(LeyNorma leyNorma){
		getPk().setLeyNorma(leyNorma);
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_acceso", nullable = false)
	public Date getFecha_acceso() {
		return fecha_acceso;
	}
	
	public void setFecha_acceso(Date fecha_acceso) {
		this.fecha_acceso = fecha_acceso;
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		HistorialNavegacionDeUsuario that = (HistorialNavegacionDeUsuario) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
	
}
