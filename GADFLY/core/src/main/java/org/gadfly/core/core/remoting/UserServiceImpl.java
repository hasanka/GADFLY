package org.gadfly.core.core.remoting;

import org.gadfly.core.api.domain.User;
import org.gadfly.core.api.service.UserService;
import org.gadfly.core.core.persistence.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 
 * @author HasankaMac
 *
 */
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;

	@Override
	public void saveUser(User user) {
		userDAO.saveUser(user);
	}
	
}
