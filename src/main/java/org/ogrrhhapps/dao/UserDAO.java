package org.ogrrhhapps.dao;

import org.ogrrhhapps.entities.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
public interface UserDAO {  
    
    public User getUser(String login);  
  
}  