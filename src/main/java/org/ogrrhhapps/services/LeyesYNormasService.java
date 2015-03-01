package org.ogrrhhapps.services;

import java.util.List;

import org.ogrrhhapps.entities.LeyNorma;

public interface LeyesYNormasService {
	
	public List<LeyNorma> obtenerLeyesYNormas();
	public List<LeyNorma> obtenerLeyesYNormasPorBuscador(String criterioBusqueda);
	public String readHtmlFile(String url);
}
