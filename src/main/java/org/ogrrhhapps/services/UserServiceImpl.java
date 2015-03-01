package org.ogrrhhapps.services;

import org.ogrrhhapps.dao.UserDAO;
import org.ogrrhhapps.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired  
    private UserDAO userDAO;  
  
    public User getUser(String login) {  
        return userDAO.getUser(login);  
    }  

}
