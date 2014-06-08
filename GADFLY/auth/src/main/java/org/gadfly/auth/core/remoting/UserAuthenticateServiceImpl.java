package org.gadfly.auth.core.remoting;

import org.gadfly.auth.api.service.UserAuthenticateService;
import org.gadfly.core.api.to.UserDTO;
import org.gadfly.core.core.persistence.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class UserAuthenticateServiceImpl implements UserAuthenticateService{

	@Autowired
	private UserDAO userDAO;
	
	public boolean authenticateUser(UserDTO dto) {
		return userDAO.authenticateUser(dto);
	}

}
