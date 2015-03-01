package org.ogrrhhapps.dao;

import java.util.List;

import org.ogrrhhapps.entities.Nota;

public interface AnotacionDAO {

	public List<Nota> obtenerAnotacionesPorLey(Long id_normas);
	public boolean registrarAnotacionALey(Long id_normas, String textoLey);
}
