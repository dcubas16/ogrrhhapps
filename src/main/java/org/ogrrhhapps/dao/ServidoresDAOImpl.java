package org.ogrrhhapps.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.ogrrhhapps.entities.Servidor;
import org.ogrrhhapps.entities.ServidorTotalDU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ServidoresDAOImpl implements
		ServidoresDAO {

	JsonHelper jsonHelper;
	
	@Autowired
    private SessionFactory sessionFactory;

	
	@SuppressWarnings("rawtypes")
	@Override
	@Transactional
	public String getServidores(String serDocIdAct, String serApePat,
			String serApeMat, String serNombres) {
		
		Iterator i = sessionFactory.getCurrentSession().createQuery("select s.serDocIdAct as serDocIdAct"
				+ ", s.serApePat as serApePat"
				+ ", s.serApeMat as serApeMat"
				+ ", s.serNombres as serNombres"
				+ ", sum(r.totalDu37) as total_du "
				+ "from Servidor as s "
				+ "inner join s.servidorTrabajos as st "
				+ "inner join st.remuneraciones as r  "
				+ "where UPPER(TRIM(s.serDocIdAct)) LIKE '%"+ serDocIdAct.trim().toUpperCase() + "%'"+
				"and UPPER(TRIM(s.serApePat)) LIKE '%"+ serApePat.trim().toUpperCase() + "%'"+
				"and UPPER(TRIM(s.serApeMat)) LIKE '%"+ serApeMat.trim().toUpperCase() + "%'"+
				"and UPPER(TRIM(s.serNombres)) LIKE '%"+ serNombres.trim().toUpperCase() + "%' "
						+ "group by s.serDocIdAct, s.serApePat, s.serApeMat, s.serNombres ").list().iterator();
		
		List<ServidorTotalDU> servidorTotalDUs = new ArrayList<ServidorTotalDU>();
		
		while (i.hasNext()) {
			  Object[] tuple = (Object[]) i.next();
			  servidorTotalDUs.add(new ServidorTotalDU(tuple[0].toString(), tuple[1].toString(), tuple[2].toString(), tuple[3].toString(), Double.parseDouble( tuple[4].toString() ) ));
			
		}

		jsonHelper = new JsonHelper(servidorTotalDUs);
		System.out.println("Hello"+jsonHelper.getJsonString());
		
		return jsonHelper.getJsonString();
	}
	
	@Override
	@Transactional
	public Servidor getServidor(String serDocIdAct) {
		
		@SuppressWarnings("unchecked")
		List<Servidor> servidores = (List<Servidor>)sessionFactory.getCurrentSession()
				.createQuery("from Servidor where UPPER(TRIM(serDocIdAct)) = :serDocIdAct")
				.setParameter("serDocIdAct", serDocIdAct.trim().toUpperCase()).list();
		
		return servidores.get(0);
	}

}
