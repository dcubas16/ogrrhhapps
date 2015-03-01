package org.ogrrhhapps.services;

import java.util.List;

import org.ogrrhhapps.entities.Nota;

public interface AnotacionesService {
	
	public List<Nota> obtenerAnotacionesPorLey(Long id_normas);
	public boolean registrarAnotacionALey(Long id_normas, String textoLey);
}
