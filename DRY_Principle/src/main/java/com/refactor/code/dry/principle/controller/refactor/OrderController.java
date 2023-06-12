package com.refactor.code.dry.principle.controller.refactor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.refactor.code.dry.principle.model.Order;

@RestController
@RequestMapping("/orders")
public class OrderController extends CrudController<Order, Long>{
	
    // no need to repeat CRUD methods here

}
