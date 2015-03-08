package org.ogrrhhapps.services;

import java.util.List;

import org.ogrrhhapps.dao.RemuneracionDao;
import org.ogrrhhapps.entities.Remuneracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemuneracionServiceImpl implements RemuneracionService {

	@Autowired
	private RemuneracionDao remuneracionDao;

	@Override
	public List<Remuneracion> getRemuneraciones(String serDocIdAct) {
		return remuneracionDao.getRemuneraciones(serDocIdAct);
	}

}
