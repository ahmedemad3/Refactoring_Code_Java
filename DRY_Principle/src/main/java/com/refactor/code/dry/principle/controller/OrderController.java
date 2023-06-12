package com.refactor.code.dry.principle.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.refactor.code.dry.principle.model.Order;
import com.refactor.code.dry.principle.repository.OrderRepository;

@RestController
public class OrderController {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @GetMapping("/orders")
    public List<Order> getOrders() {
        return (List<Order>) orderRepository.findAll();
    }
    
    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        Order savedOrder = orderRepository.save(order);
        return savedOrder;
    }
    
    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable("id") Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            return optionalOrder.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");
        }
    }
    
    @PutMapping("/orders/{id}")
    public Order updateOrder(@PathVariable("id") Long id, @RequestBody Order order) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            Order existingOrder = optionalOrder.get();
            existingOrder.setCustomerName(order.getCustomerName());
            existingOrder.setTotal(order.getTotal());
            Order updatedOrder = orderRepository.save(existingOrder);
            return updatedOrder;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");
        }
    }
    
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Long id) {
        orderRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
