package org.gadfly.core.api.service;

import java.util.List;

import org.gadfly.core.api.domain.User;
import org.gadfly.core.api.to.UserDTO;
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
	void saveUser(User user);
	
	/**
	 * 
	 * @param userDTO
	 * @return
	 */
	List<User>searchUsers(UserDTO userDTO);
	
	
}
