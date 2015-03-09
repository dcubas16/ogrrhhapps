package org.ogrrhhapps.dao;

import org.ogrrhhapps.entities.Servidor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
public interface ServidoresDAO {

	public String getServidores(String serDocIdAct, String serApePat,
			String serApeMat, String serNombres);
	
	public Servidor getServidor(String serDocIdAct);
}


