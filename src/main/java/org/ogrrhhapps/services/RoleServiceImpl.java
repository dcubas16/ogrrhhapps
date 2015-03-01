package org.ogrrhhapps.services;

import org.ogrrhhapps.dao.RoleDAO;
import org.ogrrhhapps.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements RoleService {

	@Autowired  
    private RoleDAO roleDAO;  
  
    public Role getRole(int id) {  
    	
        return roleDAO.getRole(id);  
    }  
}
