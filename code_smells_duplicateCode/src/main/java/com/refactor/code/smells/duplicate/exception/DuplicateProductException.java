package com.refactor.code.smells.duplicate.exception;

import com.refactor.code.smells.duplicate.model.ErrorType;

public class DuplicateProductException extends ApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1801704201349649109L;

	public DuplicateProductException() {
	}

	public DuplicateProductException(String message, Integer code) {
		super(message, code);
	}

	public DuplicateProductException(String message, Integer code, ErrorType errorType) {
		super(message, code, errorType);

	}

}
