package org.gadfly.core.core.exception;

/**
 * 
 * @author HasankaMac
 *
 */
public class GadfyDaoException extends GadfyException{

	private static final long serialVersionUID = 1L;

	public GadfyDaoException(String message, String errorCode,Throwable caouse) {
		super(message, errorCode,caouse);
	}
}
