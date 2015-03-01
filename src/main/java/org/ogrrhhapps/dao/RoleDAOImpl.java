package org.ogrrhhapps.dao;

import org.hibernate.Session;
import org.ogrrhhapps.entities.Role;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class RoleDAOImpl extends HibernateDaoSupport  implements RoleDAO {
	
	@Override
	public Role getRole(int id) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Role role = (Role) session.createQuery("from Role r where r.id = "+ id);
		session.close();
		return role;
	}

}
