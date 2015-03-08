package org.ogrrhhapps.services;

import java.util.List;

import org.ogrrhhapps.entities.Remuneracion;

public interface RemuneracionService {

	public List<Remuneracion> getRemuneraciones(String serDocIdAct);
}
