package org.ogrrhhapps.services;

import java.util.List;

import org.ogrrhhapps.dao.AnotacionDAO;
import org.ogrrhhapps.entities.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnotacionesServiceImpl implements AnotacionesService {

	@Autowired
	private AnotacionDAO anotacionesDAO;
	
	@Override
	public List<Nota> obtenerAnotacionesPorLey(Long id_normas) {
		
		return anotacionesDAO.obtenerAnotacionesPorLey(id_normas);
	}

	@Override
	public boolean registrarAnotacionALey(Long id_normas, String textoLey) {
		
		return anotacionesDAO.registrarAnotacionALey(id_normas, textoLey);
	}

}
