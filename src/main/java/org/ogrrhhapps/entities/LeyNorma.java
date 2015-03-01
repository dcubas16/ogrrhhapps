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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ley_normas")
public class LeyNorma implements java.io.Serializable {
	private static final long serialVersionUID = -8957481842020497160L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id_normas", unique = true, nullable = false)
	private Long id_normas;

	@Column(name="pais")
	private String pais;
	
	@Column(name="tipo")
	private String tipo;

	@Column(name="numero_norma")
	private String numero_norma;

	@Column(name="descripcion")
	private String descripcion;

	@Column(name="contenido")
	private String contenido;

	@Column(name="fecha_dacion")
	private String fecha_dacion;

	@Column(name="fecha_promulgacion")
	private String fecha_promulgacion;

	@Column(name="fecha_publicacion")
	private String fecha_publicacion;

	@Column(name="estado")
	private String estado;
	
	@Column(name="url")
	private String url;
	
	@Column(name="pdf")
	private String pdf;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "id_normas", cascade=CascadeType.ALL, targetEntity=LeyNorma.class)
	private Set<HistorialNavegacionDeUsuario> historialNavegacionDeUsuarios = new HashSet<HistorialNavegacionDeUsuario>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_normas", cascade=CascadeType.ALL, targetEntity=LeyNorma.class)
	private Set<Nota> notas = new HashSet<Nota>(0);
	
	public LeyNorma() {}
	
	public LeyNorma(String pais, String tipo,
			String numero_norma, String descripcion, String contenido,
			String fecha_dacion, String fecha_promulgacion,
			String fecha_publicacion, String estado, String url, String pdf) {
		super();
		this.pais = pais;
		this.tipo = tipo;
		this.numero_norma = numero_norma;
		this.descripcion = descripcion;
		this.contenido = contenido;
		this.fecha_dacion = fecha_dacion;
		this.fecha_promulgacion = fecha_promulgacion;
		this.fecha_publicacion = fecha_publicacion;
		this.estado = estado;
		this.url = url;
		this.pdf = pdf;
	}
	
	public LeyNorma(Long id_normas, String pais, String tipo,
			String numero_norma, String descripcion, String contenido,
			String fecha_dacion, String fecha_promulgacion,
			String fecha_publicacion, String estado, String url,
			Set<HistorialNavegacionDeUsuario> historialNavegacionDeUsuarios,
			Set<Nota> notas,
			String pdf) {
		super();
		this.id_normas = id_normas;
		this.pais = pais;
		this.tipo = tipo;
		this.numero_norma = numero_norma;
		this.descripcion = descripcion;
		this.contenido = contenido;
		this.fecha_dacion = fecha_dacion;
		this.fecha_promulgacion = fecha_promulgacion;
		this.fecha_publicacion = fecha_publicacion;
		this.estado = estado;
		this.url = url;
		this.historialNavegacionDeUsuarios = historialNavegacionDeUsuarios;
		this.notas = notas;
		this.pdf = pdf;
	}

	public Set<HistorialNavegacionDeUsuario> getHistorialNavegacionDeUsuarios() {
		return historialNavegacionDeUsuarios;
	}

	public void setHistorialNavegacionDeUsuarios(
			Set<HistorialNavegacionDeUsuario> historialNavegacionDeUsuarios) {
		this.historialNavegacionDeUsuarios = historialNavegacionDeUsuarios;
	}

	public Set<Nota> getNotas() {
		return notas;
	}

	public void setNotas(Set<Nota> notas) {
		this.notas = notas;
	}

	public Long getId_normas() {
		return id_normas;
	}

	public void setId_normas(Long id_normas) {
		this.id_normas = id_normas;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero_norma() {
		return numero_norma;
	}

	public void setNumero_norma(String numero_norma) {
		this.numero_norma = numero_norma;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getFecha_dacion() {
		return fecha_dacion;
	}

	public void setFecha_dacion(String fecha_dacion) {
		this.fecha_dacion = fecha_dacion;
	}

	public String getFecha_promulgacion() {
		return fecha_promulgacion;
	}

	public void setFecha_promulgacion(String fecha_promulgacion) {
		this.fecha_promulgacion = fecha_promulgacion;
	}

	public String getFecha_publicacion() {
		return fecha_publicacion;
	}

	public void setFecha_publicacion(String fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
}
