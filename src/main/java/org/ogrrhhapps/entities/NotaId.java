package org.ogrrhhapps.entities;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Embeddable
public class NotaId implements java.io.Serializable{

	private LeyNorma leyNorma;
	
	@ManyToOne(fetch = FetchType.LAZY)
	public LeyNorma getLeyNorma() {
		return leyNorma;
	}
	
	public void setLeyNorma(LeyNorma leyNorma) {
		this.leyNorma = leyNorma;
	}	
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotaId that = (NotaId) o;

        if (leyNorma != null ? !leyNorma.equals(that.leyNorma) : that.leyNorma != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (leyNorma != null ? leyNorma.hashCode() : 0);
        result = 31 * result + (leyNorma != null ? leyNorma.hashCode() : 0);
        return result;
    }
	
	private static final long serialVersionUID = 4716822984122923717L;

	
}
