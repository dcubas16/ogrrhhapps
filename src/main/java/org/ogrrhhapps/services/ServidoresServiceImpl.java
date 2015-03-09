package org.ogrrhhapps.services;

import org.ogrrhhapps.dao.ServidoresDAO;
import org.ogrrhhapps.entities.Servidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServidoresServiceImpl implements ServidoresService {

	@Autowired
	private ServidoresDAO servidoresDAO;

	@Override
	public String getServidores(String serDocIdAct, String serApePat,
			String serApeMat, String serNombres) {

		return servidoresDAO.getServidores(serDocIdAct, serApePat, serApeMat, serNombres);
	}

	@Override
	public Servidor getServidor(String serDocIdAct) {
		// TODO Auto-generated method stub
		return servidoresDAO.getServidor(serDocIdAct);
	}

}
