package com.refactor.code.smells.duplicate.error;

public class DuplicateProductErrorMessage implements ErrorMessage{

	@Override
	public String getMessage() {
		return "Product with the same name already exists";
	}

}
