package org.ogrrhhapps.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "usuarios")
public class Usuario  implements java.io.Serializable{
	private static final long serialVersionUID = -8625064100303307451L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario", unique = true, nullable = false)
	private Long id_usuario;

	@Column(name = "nombre", unique = true,  nullable = false)
	private String nombre;

	@Column(name = "password")
	private String password;

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy= "id_usuario", targetEntity=Usuario.class)
	private Set<HistorialNavegacionDeUsuario> historialNavegacionDeUsuarios= new HashSet<HistorialNavegacionDeUsuario>(0);
	
	public Usuario(){}

	public Usuario(String nombre, String password) {
		super();
		this.nombre = nombre;
		this.password = password;
	}
	
	public Usuario(Long id_usuario, String nombre, String password,
			Set<HistorialNavegacionDeUsuario> historialNavegacionDeUsuarios) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.password = password;
		this.historialNavegacionDeUsuarios = historialNavegacionDeUsuarios;
	}

	public Set<HistorialNavegacionDeUsuario> getHistorialNavegacionDeUsuarios() {
		return historialNavegacionDeUsuarios;
	}

	public void setHistorialNavegacionDeUsuarios(
			Set<HistorialNavegacionDeUsuario> historialNavegacionDeUsuarios) {
		this.historialNavegacionDeUsuarios = historialNavegacionDeUsuarios;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
