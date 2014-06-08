package org.gadfly.core.core.remoting;

import java.util.List;

import org.gadfly.core.api.domain.User;
import org.gadfly.core.api.service.UserService;
import org.gadfly.core.api.to.UserDTO;
import org.gadfly.core.core.exception.GadfyException;
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
	public void saveUser(User user) throws GadfyException{
		userDAO.saveUser(user);
	}

	@Override
	public List<User> searchUsers(UserDTO userDTO) throws GadfyException {
		return userDAO.searchUsers(userDTO);
	}

}
