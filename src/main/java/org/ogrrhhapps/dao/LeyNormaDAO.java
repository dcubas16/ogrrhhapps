package org.ogrrhhapps.dao;

import java.util.Date;
import java.util.List;

import org.ogrrhhapps.entities.HistorialNavegacionDeUsuario;
import org.ogrrhhapps.entities.LeyNorma;
import org.ogrrhhapps.entities.Usuario;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
public interface LeyNormaDAO {

	public List<LeyNorma> obtenerLeyesYNormas();
	public List<LeyNorma> obtenerLeyesYNormasPorBuscador(String criterioBusqueda);
	public boolean registrarNavegacionDeUsuario(Usuario user, LeyNorma leyNorma, Date fechaAcceso);
	public List<HistorialNavegacionDeUsuario> obtenerHistorialNavegacionDeUsuario(Long id_usuario);
}
