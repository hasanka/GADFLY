package org.gadfly.core.core.exception;

public class GadfyException  extends Exception {

	private static final long serialVersionUID = 1L;

	private String errorCode="Unknown_Exception";

    public GadfyException(String message, String errorCode,Throwable cause){
        super(message,cause);
        this.errorCode=errorCode;
    }
    
	public String getErrorCode() {
		return errorCode;
	}
    
}
