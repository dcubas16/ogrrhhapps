package org.ogrrhhapps.services;

import org.ogrrhhapps.entities.Servidor;

public interface ServidoresService {

	public String getServidores(String serDocIdAct,String  serApePat,String  serApeMat,String  serNombres);
	
	public Servidor getServidor(String serDocIdAct);
}
