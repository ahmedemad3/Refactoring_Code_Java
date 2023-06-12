package com.refactor.code.smells.longclasses.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.refactor.code.smells.longclasses.model.Order;
import com.refactor.code.smells.longclasses.model.OrderDTO;
import com.refactor.code.smells.longclasses.model.OrderItem;
import com.refactor.code.smells.longclasses.model.OrderItemDTO;
import com.refactor.code.smells.longclasses.repository.OrderRepository;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	private OrderRepository orderRepository;
	
	@GetMapping("/users/{userId}/orders")
	public List<OrderDTO> getOrderHistoryForUser(@PathVariable Long userId) {
	    List<Order> orders = orderRepository.getOrderHistoryForUser(userId);
	    List<OrderDTO> orderDTOs = new ArrayList<>();
	    for (Order order : orders) {
	        OrderDTO orderDTO = new OrderDTO();
	        orderDTO.setId(order.getId());
	        orderDTO.setOrderDate(order.getOrderDate());
	        orderDTO.setTotalPrice(order.getTotalPrice());
	        List<OrderItemDTO> orderItemDTOs = new ArrayList<>();
	        for (OrderItem orderItem : order.getOrderItems()) {
	            OrderItemDTO orderItemDTO = new OrderItemDTO();
	            orderItemDTO.setId(orderItem.getId());
	            orderItemDTO.setProductName(orderItem.getProductName());
	            orderItemDTO.setQuantity(orderItem.getQuantity());
	            orderItemDTO.setTotalPrice(orderItem.getTotalPrice());
	            orderItemDTOs.add(orderItemDTO);
	        }
	        orderDTO.setOrderItemDTOs(orderItemDTOs);
	        orderDTOs.add(orderDTO);
	    }
	    return orderDTOs;
	}


}
