package org.ogrrhhapps.entities;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class HistorialNavegacionDeUsuarioId  implements java.io.Serializable{
	private static final long serialVersionUID = -6899275377834631932L;
	
	private Usuario usuario;
	private LeyNorma leyNorma;
	
	@ManyToOne
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@ManyToOne
	public LeyNorma getLeyNorma() {
		return leyNorma;
	}
	
	public void setLeyNorma(LeyNorma leyNorma) {
		this.leyNorma = leyNorma;
	}	
	
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistorialNavegacionDeUsuarioId that = (HistorialNavegacionDeUsuarioId) o;

        if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;
        if (leyNorma != null ? !leyNorma.equals(that.leyNorma) : that.leyNorma != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (leyNorma != null ? leyNorma.hashCode() : 0);
        return result;
    }
}
