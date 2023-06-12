package com.refactor.code.smells.duplicate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.refactor.code.smells.duplicate.exception.ApplicationException;
import com.refactor.code.smells.duplicate.model.Product;
import com.refactor.code.smells.duplicate.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/products")
	public ResponseEntity<String> createProduct(@RequestBody Product product) {
		try {
			productService.createProduct(product);
			return ResponseEntity.ok("Product created successfully");
		} catch (ApplicationException e) {
			e.printStackTrace();
			switch (e.getErrorType().name().toLowerCase()) {
			case "invalid_product":
				return ResponseEntity.badRequest().body("Product name is required");
			case "duplicate_product":
				return ResponseEntity.badRequest().body("Product with the same name already exists");
			case "invalid_price":
				return ResponseEntity.badRequest().body("Product price must be a positive number");
			default:
				return ResponseEntity.badRequest().body("Invalid product information");
			}
		}
	}
	
	
	/**
	 * As we can see, the switch statement is being used to return different error
	 * messages based on the type of exception that is thrown. However, we can use
	 * the strategy pattern to refactor this code and eliminate the switch
	 * statement. First, we can define an interface for the error messages:
	 */

}
