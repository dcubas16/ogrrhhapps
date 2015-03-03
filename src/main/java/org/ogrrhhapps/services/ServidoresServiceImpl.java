package org.ogrrhhapps.services;

import org.ogrrhhapps.dao.ServidoresDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServidoresServiceImpl implements ServidoresService {

	@Autowired
	private ServidoresDAO servidoresDAO;

	@Override
	public String getServidores(String serDocIdAct, String serApePat,
			String serApeMat, String serNombres) {

		servidoresDAO.getServidores(serDocIdAct, serApePat, serApeMat, serNombres);
		
		return null;
	}

}
