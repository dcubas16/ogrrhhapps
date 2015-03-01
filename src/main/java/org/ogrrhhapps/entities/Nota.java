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

@Entity
@Table(name = "notas")
public class Nota implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_nota", unique = true, nullable = false)
	private Long id_nota;
	
	@Column(name = "textoley", nullable = false)
	private String textoLey;
	
	@Column(name = "descripcionnota")
	private String descripcionNota;
	
	@Column(name = "todasleyes")
	private int todasLeyes;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "leynorma_id_normas")
	private LeyNorma leyNorma;
	
	public LeyNorma getLeyNorma() {
		return leyNorma;
	}

	public void setLeyNorma(LeyNorma leyNorma) {
		this.leyNorma = leyNorma;
	}

	public Nota() {}

	public Nota(Long id_nota, String textoLey, String descripcionNota,
			int todasLeyes) {
		super();
		this.id_nota = id_nota;
		this.textoLey = textoLey;
		this.descripcionNota = descripcionNota;
		this.todasLeyes = todasLeyes;
	}
	
	public Nota(String textoLey, String descripcionNota,
			int todasLeyes) {
		super();
		this.textoLey = textoLey;
		this.descripcionNota = descripcionNota;
		this.todasLeyes = todasLeyes;
	}

	public Long getId_nota() {
		return id_nota;
	}

	public void setId_nota(Long id_nota) {
		this.id_nota = id_nota;
	}

	public String getTextoLey() {
		return textoLey;
	}

	public void setTextoLey(String textoLey) {
		this.textoLey = textoLey;
	}

	public String getDescripcionNota() {
		return descripcionNota;
	}

	public void setDescripcionNota(String descripcionNota) {
		this.descripcionNota = descripcionNota;
	}

	public int isTodasLeyes() {
		return todasLeyes;
	}

	public void setTodasLeyes(int todasLeyes) {
		this.todasLeyes = todasLeyes;
	}
	
	private static final long serialVersionUID = 3552145257388864686L;
}
