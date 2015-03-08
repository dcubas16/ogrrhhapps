package org.ogrrhhapps.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.ogrrhhapps.entities.Remuneracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RemuneracionDaoImpl implements RemuneracionDao {

	@Autowired
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Remuneracion> getRemuneraciones(String serDocIdAct) {
		
		List<Remuneracion> remuneraciones = (List<Remuneracion>) sessionFactory.getCurrentSession().createQuery("select r from Remuneracion as r "
				+ "inner join fetch r.servidorTrabajo as st "
				+ "where r.serDocIdAct = :serDocIdAct order by r.plaAnu, r.plaMes").setParameter("serDocIdAct", serDocIdAct).list();
		return remuneraciones;
	}

}
