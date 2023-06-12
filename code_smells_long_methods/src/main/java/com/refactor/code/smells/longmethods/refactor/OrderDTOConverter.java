package com.refactor.code.smells.longmethods.refactor;

import org.springframework.stereotype.Component;

import com.refactor.code.smells.longmethods.model.Order;
import com.refactor.code.smells.longmethods.model.OrderDTO;

@Component
public class OrderDTOConverter implements Converter<Order, OrderDTO>{

	@Override
	public OrderDTO convert(Order order) {
		OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setTotalPrice(order.getTotalPrice());
        orderDTO.setOrderDate(order.getOrderDate());
        return orderDTO;
	}

}
