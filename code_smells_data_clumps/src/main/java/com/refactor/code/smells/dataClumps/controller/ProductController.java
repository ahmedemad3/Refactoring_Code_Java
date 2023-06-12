package com.refactor.code.smells.dataClumps.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.refactor.code.smells.dataClumps.model.Product;
import com.refactor.code.smells.dataClumps.model.User;
import com.refactor.code.smells.dataClumps.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        // Retrieve product details from the database
        Product product = productService.getProductById(id);

        // Apply discount based on user type
        User currentUser = getCurrentUser();
        if (currentUser.getRole().equals("premium")) {
            product.setPrice(product.getPrice().subtract(BigDecimal.TEN)); // subtract 10
        }

        return ResponseEntity.ok(product);
    }

    private User getCurrentUser() {
        User user = new User();
        user.setUserId(1L);
        user.setUsername("john.doe");
        user.setRole("premium");  // we need to have more than one role like [free , enterprise]
        return user;
    }
    
    /**
     * Problem 
     * 
     * we can see a data clump in the getProductById method. The discount calculation is based on the user's role, 
     * which is retrieved from the currentUser object. 
     * This data clump occurs when the same set of data (user role and discount calculation) is used together in multiple places.
     */
    
    
    /**
     * Solution
     * we can apply the Extract Method and Introduce Parameter Object techniques
     */

}

