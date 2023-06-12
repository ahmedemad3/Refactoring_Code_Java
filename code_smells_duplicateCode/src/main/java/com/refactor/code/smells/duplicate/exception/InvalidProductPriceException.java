package com.refactor.code.smells.duplicate.exception;

import com.refactor.code.smells.duplicate.model.ErrorType;

public class InvalidProductPriceException extends ApplicationException {

	public InvalidProductPriceException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidProductPriceException(String message, Integer code) {
		super(message, code);
	}

	public InvalidProductPriceException(String message, Integer code, ErrorType errorType) {
		super(message, code, errorType);

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1138281691704563412L;

}
