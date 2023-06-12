package com.refactor.code.smells.duplicate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.refactor.code.smells.duplicate.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
