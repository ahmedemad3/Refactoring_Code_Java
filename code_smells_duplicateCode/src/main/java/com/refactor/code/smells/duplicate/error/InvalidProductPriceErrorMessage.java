package com.refactor.code.smells.duplicate.error;

public class InvalidProductPriceErrorMessage implements ErrorMessage{

	@Override
	public String getMessage() {
		return "Product price must be a positive number";
	}

}
