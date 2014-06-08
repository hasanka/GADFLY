package org.gadfly.core.api.service;

import java.util.List;

import org.gadfly.core.api.domain.User;
import org.gadfly.core.api.to.UserDTO;
import org.gadfly.core.core.exception.GadfyException;
/**
 * 
 * @author HasankaMac
 *
 */
public interface UserService {

	/**
	 * 
	 * @param user
	 */
	void saveUser(User user) throws GadfyException;
	
	/**
	 * 
	 * @param userDTO
	 * @return
	 */
	List<User>searchUsers(UserDTO userDTO) throws GadfyException;
	
	
}
