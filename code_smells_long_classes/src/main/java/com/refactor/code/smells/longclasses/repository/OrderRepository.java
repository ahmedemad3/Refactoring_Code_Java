package com.refactor.code.smells.longclasses.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.refactor.code.smells.longclasses.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> getOrderHistoryForUser(Long userId);

}
