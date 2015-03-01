package org.ogrrhhapps.services;

import java.util.Date;
import java.util.List;

import org.ogrrhhapps.entities.HistorialNavegacionDeUsuario;
import org.ogrrhhapps.entities.LeyNorma;
import org.ogrrhhapps.entities.Usuario;

public interface UserNavigationHistoryService {
	public boolean registrarNavegacionDeUsuario(Usuario user, LeyNorma leyNorma, Date fechaAcceso);
	public List<HistorialNavegacionDeUsuario> obtenerHistorialNavegacionDeUsuario(Long id_usuario);
}
