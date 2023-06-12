package com.refactor.code.dry.principle.repository;

import org.springframework.data.repository.CrudRepository;

import com.refactor.code.dry.principle.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

}
