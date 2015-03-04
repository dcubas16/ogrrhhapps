package org.ogrrhhapps.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.ogrrhhapps.entities.Servidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ServidoresDAOImpl extends HibernateDaoSupport implements
		ServidoresDAO {

	JsonHelper jsonHelper;
	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}


	@Override
	public String getServidores(String serDocIdAct, String serApePat,
			String serApeMat, String serNombres) {

		Object objecServidores = getHibernateTemplate().find("from Servidor");
		jsonHelper = new JsonHelper(objecServidores);
		
		return jsonHelper.getJsonString();
	}
}
