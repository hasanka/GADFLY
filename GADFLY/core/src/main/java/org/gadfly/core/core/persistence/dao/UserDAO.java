package org.gadfly.core.core.persistence.dao;

import java.util.List;

import org.gadfly.core.api.domain.User;
import org.gadfly.core.api.to.UserDTO;
import org.gadfly.core.core.exception.GadfyException;

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
	User saveUser(User user) throws GadfyException;
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	List<User> searchUsers(UserDTO dto) throws GadfyException;
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	boolean authenticateUser(UserDTO dto) throws GadfyException;
	
	
	
}
