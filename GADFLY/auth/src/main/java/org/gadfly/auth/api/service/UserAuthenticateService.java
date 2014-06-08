package org.gadfly.auth.api.service;

import org.gadfly.core.api.to.UserDTO;

public interface UserAuthenticateService {

	/**
	 * 
	 * @param dto
	 * @return
	 */
	boolean authenticateUser(UserDTO dto);
}
