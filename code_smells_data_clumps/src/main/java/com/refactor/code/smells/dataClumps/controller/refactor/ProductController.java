package com.refactor.code.smells.dataClumps.controller.refactor;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.refactor.code.smells.dataClumps.model.Product;
import com.refactor.code.smells.dataClumps.model.User;
import com.refactor.code.smells.dataClumps.service.DiscountService;
import com.refactor.code.smells.dataClumps.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
    private ProductService productService;
	
	@Autowired
    private DiscountService discountService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        // Retrieve product details from the database
        Product product = productService.getProductById(id);

        // Apply discount based on user type
        User currentUser = getCurrentUser();
        double discountedPrice = discountService.calculateDiscount(currentUser.getRole(), product.getPrice());
        product.setPrice(BigDecimal.valueOf(discountedPrice));

        return ResponseEntity.ok(product);
    }

    // Other methods...
    
    private User getCurrentUser() {
        User user = new User();
        user.setUserId(1L);
        user.setUsername("john.doe");
        user.setRole("premium");
        return user;
    }
}
