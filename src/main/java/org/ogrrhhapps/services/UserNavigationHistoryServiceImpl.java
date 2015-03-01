package org.ogrrhhapps.services;

import java.util.Date;
import java.util.List;

import org.ogrrhhapps.dao.LeyNormaDAO;
import org.ogrrhhapps.entities.HistorialNavegacionDeUsuario;
import org.ogrrhhapps.entities.LeyNorma;
import org.ogrrhhapps.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserNavigationHistoryServiceImpl implements
		UserNavigationHistoryService {

	@Autowired
	private LeyNormaDAO leyNormaDAO;
	
	@Autowired
	public UserNavigationHistoryServiceImpl(LeyNormaDAO leyNormaDAO){
		this.leyNormaDAO = leyNormaDAO;
	}
	
	@Override
	public boolean registrarNavegacionDeUsuario(Usuario user, LeyNorma leyNorma, Date fechaAcceso) {
		return leyNormaDAO.registrarNavegacionDeUsuario(user, leyNorma, fechaAcceso);
	}

	@Override
	public List<HistorialNavegacionDeUsuario> obtenerHistorialNavegacionDeUsuario(Long id_usuario) {
		return leyNormaDAO.obtenerHistorialNavegacionDeUsuario(id_usuario);
	}


}
