package org.gadfly.auth.api.service;

import org.gadfly.core.api.to.UserDTO;
import org.gadfly.core.core.exception.GadfyException;

public interface UserAuthenticateService {

	/**
	 * 
	 * @param dto
	 * @return
	 */
	boolean authenticateUser(UserDTO dto) throws GadfyException;
}
