package org.gadfly.core.core.persistence.dao;

import java.util.List;

import org.gadfly.core.api.domain.User;
import org.gadfly.core.api.to.UserDTO;

/**
 * 
 * @author HasankaMac
 *
 */
public interface UserDAO {
	
	/**
	 * 
	 * @param user
	 */
	User saveUser(User user);
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	List<User> searchUsers(UserDTO dto);
	
}
