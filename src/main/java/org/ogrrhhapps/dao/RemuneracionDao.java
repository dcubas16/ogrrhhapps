package org.ogrrhhapps.dao;

import java.util.List;

import org.ogrrhhapps.entities.Remuneracion;

public interface RemuneracionDao {

	List<Remuneracion> getRemuneraciones(String serDocIdAct);

}
