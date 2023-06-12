package com.refactor.code.smells.duplicate.controller.refactor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.refactor.code.smells.duplicate.error.DuplicateProductErrorMessage;
import com.refactor.code.smells.duplicate.error.ErrorMessage;
import com.refactor.code.smells.duplicate.error.InvalidProductErrorMessage;
import com.refactor.code.smells.duplicate.error.InvalidProductPriceErrorMessage;
import com.refactor.code.smells.duplicate.exception.ApplicationException;
import com.refactor.code.smells.duplicate.exception.DuplicateProductException;
import com.refactor.code.smells.duplicate.exception.InvalidProductException;
import com.refactor.code.smells.duplicate.exception.InvalidProductPriceException;
import com.refactor.code.smells.duplicate.model.Product;
import com.refactor.code.smells.duplicate.service.ProductService;

@RestController
public class ProductController { // NOPMD by ahmed on 5/25/23, 10:17 AM
	
	private static final Map<Class<? extends Exception>, ErrorMessage> ERROR_MESSAGES = new ConcurrentHashMap<>(); // NOPMD by ahmed on 5/25/23, 10:17 AM
	static {
	    ERROR_MESSAGES.put(DuplicateProductException.class, new DuplicateProductErrorMessage());
	    ERROR_MESSAGES.put(InvalidProductException.class, new InvalidProductErrorMessage());
	    ERROR_MESSAGES.put(InvalidProductPriceException.class, new InvalidProductPriceErrorMessage());
	}

	
	
	@Autowired
	private ProductService productService; // NOPMD by ahmed on 5/25/23, 10:15 AM

	@PostMapping("/refactor/products")
	public ResponseEntity<String> createProduct(@RequestBody final Product product) { // NOPMD by ahmed on 5/25/23, 10:15 AM
		
		ResponseEntity<String> responseEntity = ResponseEntity.ok("Product created successfully");
		try {
			productService.createProduct(product);
		} catch (ApplicationException e) {
//			e.printStackTrace();
			final ErrorMessage errorMessage = ERROR_MESSAGES.getOrDefault(e.getClass(), new InvalidProductErrorMessage());
			responseEntity =  ResponseEntity.badRequest().body(errorMessage.getMessage());
	    }
		return responseEntity;
	}
	
	

}