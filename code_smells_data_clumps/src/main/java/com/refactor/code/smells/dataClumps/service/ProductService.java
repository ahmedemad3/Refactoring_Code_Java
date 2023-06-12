package com.refactor.code.smells.dataClumps.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.refactor.code.smells.dataClumps.model.Product;
import com.refactor.code.smells.dataClumps.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public Product getProductById(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent())
			return optionalProduct.get();
		return null;
	}

}
