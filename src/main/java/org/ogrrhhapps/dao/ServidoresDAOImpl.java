package org.ogrrhhapps.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ServidoresDAOImpl extends HibernateDaoSupport implements
		ServidoresDAO {

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}


	@Override
	public String getServidores(String serDocIdAct, String serApePat,
			String serApeMat, String serNombres) {

		getHibernateTemplate().find("from servidores where UPPER(TRIM(ser_doc_id_act)) LIKE '%"+ serDocIdAct.trim().toUpperCase() + "%'"+
"or UPPER(TRIM(ser_ape_pat)) LIKE '%"+ serApePat.trim().toUpperCase() + "%'"+
"or UPPER(TRIM(ser_ape_mat)) LIKE '%"+ serApeMat.trim().toUpperCase() + "%'"+
"or UPPER(TRIM(ser_nombres)) LIKE '%"+ serNombres.trim().toUpperCase() + "%'");
		
		return null;
	}
}
