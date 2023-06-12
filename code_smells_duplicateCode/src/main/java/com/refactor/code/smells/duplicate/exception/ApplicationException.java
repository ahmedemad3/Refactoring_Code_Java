package com.refactor.code.smells.duplicate.exception;

import com.refactor.code.smells.duplicate.model.ErrorType;

public class ApplicationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6515701382663633747L;
	
	public ApplicationException() {
		// TODO Auto-generated constructor stub
	}

	private String message;
	private Integer Code;
	private ErrorType errorType;

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationException(String message, Integer code) {
		this.message = message;
		this.Code = code;

	}
	
	public ApplicationException(String message, Integer code , ErrorType errorType) {
		this.message = message;
		this.Code = code;
		this.errorType = errorType;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return Code;
	}

	public void setCode(Integer code) {
		Code = code;
	}

	public ErrorType getErrorType() {
		return errorType;
	}

	public void setErrorType(ErrorType errorType) {
		this.errorType = errorType;
	}
	
	
}
