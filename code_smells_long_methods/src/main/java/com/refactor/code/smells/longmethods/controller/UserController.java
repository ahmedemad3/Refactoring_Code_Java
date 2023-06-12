package com.refactor.code.smells.longmethods.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.refactor.code.smells.longmethods.model.Order;
import com.refactor.code.smells.longmethods.model.OrderDTO;
import com.refactor.code.smells.longmethods.model.User;
import com.refactor.code.smells.longmethods.model.UserDTO;
import com.refactor.code.smells.longmethods.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) throws Exception {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setRole(user.getRole());

        List<Order> orders = user.getOrders();
        List<OrderDTO> orderDTOs = new ArrayList<>();
        for (Order order : orders) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(order.getId());
            orderDTO.setTotalPrice(order.getTotalPrice());
            orderDTO.setOrderDate(order.getOrderDate());
            orderDTOs.add(orderDTO);
        }
        userDTO.setOrderDTOs(orderDTOs);

        if (user.getRole().equals("admin")) {
            userDTO.setPermissions(Arrays.asList("CREATE_USER", "DELETE_USER", "EDIT_USER", "VIEW_ORDERS", "CREATE_PRODUCT", "DELETE_PRODUCT", "EDIT_PRODUCT", "VIEW_PRODUCTS"));
        } else if (user.getRole().equals("manager")) {
            userDTO.setPermissions(Arrays.asList("VIEW_ORDERS", "CREATE_PRODUCT", "DELETE_PRODUCT", "EDIT_PRODUCT", "VIEW_PRODUCTS"));
        } else {
            userDTO.setPermissions(Arrays.asList("VIEW_ORDERS", "VIEW_PRODUCTS"));
        }

        return ResponseEntity.ok(userDTO);
    }
}

