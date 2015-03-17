package org.ogrrhhapps.dao;

import java.util.ArrayList;
import java.util.Iterator;
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

	@Override
	@Transactional
	public List<Remuneracion> getRemuneraciones(String serDocIdAct) {

		@SuppressWarnings("rawtypes")
		Iterator i = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select r.id  as id, r.serDocIdAct as serDocIdAct"
								+ ", r.plaAnu as plaAnu, r.plaMes as plaMes, r.codTipPla as codTipPla, r.totalRem as totalRem, r.totalDu37 as totalDu37  from Remuneracion as r "
								+ "where r.serDocIdAct = :serDocIdAct order by r.plaAnu, r.plaMes")
				.setParameter("serDocIdAct", serDocIdAct).list().iterator();

		List<Remuneracion> remuneraciones = new ArrayList<Remuneracion>();
		
		while (i.hasNext()) {
			Object[] tuple = (Object[]) i.next();
			remuneraciones.add(new Remuneracion(tuple[1].toString(), Integer
					.parseInt(tuple[2].toString()), Integer.parseInt(tuple[3]
					.toString()), Integer.parseInt(tuple[4].toString()), Double
					.parseDouble(tuple[5].toString()), Double
					.parseDouble(tuple[6].toString())));
					
		}
		
		int anioMenor = 5000;
		for (Remuneracion remuneracion : remuneraciones) {
			if(remuneracion.getPlaAnu() < anioMenor && remuneracion.getTotalDu37() > 0  ){
				anioMenor = remuneracion.getPlaAnu();
			}
		}
		
		int mesMenor = 13;
		double duMenor = 0;
		for (Remuneracion remuneracion : remuneraciones) {
			if(remuneracion.getPlaAnu() == anioMenor && remuneracion.getPlaMes() < mesMenor && remuneracion.getTotalDu37() > 0){
				mesMenor = remuneracion.getPlaMes();
				duMenor = remuneracion.getTotalDu37();
			}
		}
		
		System.out.println(anioMenor);
		System.out.println(mesMenor);
		for (Remuneracion remuneracion : remuneraciones) {
			if(remuneracion.getPlaAnu() == anioMenor){
				if( remuneracion.getPlaMes() <= mesMenor && remuneracion.getTotalDu37() == 0 ){
					remuneracion.setTotalDu37(duMenor);
					System.out.println(duMenor);
				}
			}
			else if( remuneracion.getPlaAnu() < anioMenor ){
				if( remuneracion.getTotalDu37() == 0 ){
					remuneracion.setTotalDu37(duMenor);
					System.out.println(duMenor);
				}
			}
		}
		
		return remuneraciones;
	}

}
