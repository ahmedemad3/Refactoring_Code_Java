package com.refactor.code.smells.longclasses.model.refactor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.refactor.code.smells.longclasses.model.Order;
import com.refactor.code.smells.longclasses.model.OrderDTO;
import com.refactor.code.smells.longclasses.model.OrderItem;
import com.refactor.code.smells.longclasses.model.OrderItemDTO;

@Component
public class OrderDTOConverter {
	
	public OrderDTO convertOrderToDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setTotalPrice(order.getTotalPrice());
        orderDTO.setOrderItemDTOs(convertOrderItemsToDTOs(order.getOrderItems()));
        return orderDTO;
    }

    private List<OrderItemDTO> convertOrderItemsToDTOs(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(this::convertOrderItemToDTO)
                .collect(Collectors.toList());
    }

    private OrderItemDTO convertOrderItemToDTO(OrderItem orderItem) {
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setId(orderItem.getId());
        orderItemDTO.setProductName(orderItem.getProductName());
        orderItemDTO.setQuantity(orderItem.getQuantity());
        orderItemDTO.setTotalPrice(orderItem.getTotalPrice());
        return orderItemDTO;
    }

}
