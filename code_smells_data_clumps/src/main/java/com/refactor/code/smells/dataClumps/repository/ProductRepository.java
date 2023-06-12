package com.refactor.code.smells.dataClumps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.refactor.code.smells.dataClumps.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
