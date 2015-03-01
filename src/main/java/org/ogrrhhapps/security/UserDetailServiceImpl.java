package org.ogrrhhapps.security;

import org.ogrrhhapps.dao.UserDAO;
import org.ogrrhhapps.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserDAO userdao;
	
	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		User u;
		try {
			u = userdao.getUser(login);
			if (u == null)
				throw new UsernameNotFoundException("user name not found");

		} catch (Exception e) {
			throw new UsernameNotFoundException("database error ");
		}
		return (UserDetails) buildUserFromUserEntity(u);
	}

	private User buildUserFromUserEntity(User userEntity) {
		// convert model user to spring security user
		String username = userEntity.getLogin();
		String password = userEntity.getPassword();
//		boolean enabled = true;
//		boolean accountNonExpired = true;
//		boolean credentialsNonExpired = true;
//		boolean accountNonLocked = true;

		User springUser = new User(username, password);
		return springUser;
	}

}
