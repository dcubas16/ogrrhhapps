package org.ogrrhhapps.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ServidoresDAOSimpleImpl implements
		ServidoresDAO {

	JsonHelper jsonHelper;
	
	@Autowired
    private SessionFactory sessionFactory;

	
	@Override
	@Transactional
	public String getServidores(String serDocIdAct, String serApePat,
			String serApeMat, String serNombres) {

//		Object objecServidores = getHibernateTemplate().find("from Servidor where UPPER(TRIM(ser_doc_id_act)) LIKE '%"+ serDocIdAct.trim().toUpperCase() + "%'"+
//				"or UPPER(TRIM(ser_ape_pat)) LIKE '%"+ serApePat.trim().toUpperCase() + "%'"+
//				"or UPPER(TRIM(ser_ape_mat)) LIKE '%"+ serApeMat.trim().toUpperCase() + "%'"+
//				"or UPPER(TRIM(ser_nombres)) LIKE '%"+ serNombres.trim().toUpperCase() + "%'");
//		jsonHelper = new JsonHelper(objecServidores);
		
		Object objecServidores = sessionFactory.getCurrentSession().createQuery("select s.serDocIdAct, s.serApePat, s.serApeMat, s.serNombres, sum(r.totalDu37) from Servidor as s inner join s.servidorTrabajos as st inner join st.remuneraciones as r  where UPPER(TRIM(s.serDocIdAct)) LIKE '%"+ serDocIdAct.trim().toUpperCase() + "%'"+
				"or UPPER(TRIM(s.serApePat)) LIKE '%"+ serApePat.trim().toUpperCase() + "%'"+
				"or UPPER(TRIM(s.serApeMat)) LIKE '%"+ serApeMat.trim().toUpperCase() + "%'"+
				"or UPPER(TRIM(s.serNombres)) LIKE '%"+ serNombres.trim().toUpperCase() + "%' group by s.serDocIdAct, s.serApePat, s.serApeMat, s.serNombres ").list();
		jsonHelper = new JsonHelper(objecServidores);
		return jsonHelper.getJsonString();
	}
}
