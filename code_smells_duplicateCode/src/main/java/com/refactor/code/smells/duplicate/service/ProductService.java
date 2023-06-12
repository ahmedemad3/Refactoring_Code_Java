package com.refactor.code.smells.duplicate.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.refactor.code.smells.duplicate.error.DuplicateProductErrorMessage;
import com.refactor.code.smells.duplicate.error.InvalidProductPriceErrorMessage;
import com.refactor.code.smells.duplicate.exception.ApplicationException;
import com.refactor.code.smells.duplicate.exception.DuplicateProductException;
import com.refactor.code.smells.duplicate.exception.InvalidProductPriceException;
import com.refactor.code.smells.duplicate.model.ErrorType;
import com.refactor.code.smells.duplicate.model.Product;

@Service
public class ProductService {

	public void createProduct(Product product) throws ApplicationException {
		ErrorType errorType = ErrorType.INVALID_PRICE;
		String message = null;
		if (ErrorType.INVALID_PRICE.equals(errorType)) {
			message = new InvalidProductPriceErrorMessage().getMessage();
			throw new InvalidProductPriceException(message, HttpStatus.BAD_REQUEST.value(), errorType);
		} else {
			message = new DuplicateProductErrorMessage().getMessage();
			throw new DuplicateProductException(message, HttpStatus.BAD_REQUEST.value(),
					ErrorType.DUPLICATE_PRODUCT);
		}
	}

}
