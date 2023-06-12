package com.refactor.code.smells.duplicate.error;

public class InvalidProductErrorMessage implements ErrorMessage{

	@Override
	public String getMessage() {
		 return "Invalid product information";
	}

}
