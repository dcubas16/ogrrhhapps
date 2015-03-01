package org.ogrrhhapps.dao;

import org.ogrrhhapps.entities.Role;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
public interface RoleDAO {  
    
    public Role getRole(int id);  
  
}