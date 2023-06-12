package com.refactor.code.smells.longmethods.controller.refactor;

import java.util.List;
import java.util.stream.Collectors;

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
import com.refactor.code.smells.longmethods.refactor.OrderDTOConverter;
import com.refactor.code.smells.longmethods.refactor.UserDTOConverter;
import com.refactor.code.smells.longmethods.refactor.UserPermission;
import com.refactor.code.smells.longmethods.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserDTOConverter userDTOConverter;

	@Autowired
	private OrderDTOConverter orderDTOConverter;

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) throws Exception {
		User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException());
		UserDTO userDTO = userDTOConverter.convert(user);

		List<Order> orders = user.getOrders();
		List<OrderDTO> orderDTOs = orders.stream().map(order -> orderDTOConverter.convert(order))
				.collect(Collectors.toList());
		userDTO.setOrderDTOs(orderDTOs);
		UserPermission userPermission = userDTOConverter.assignUserPermissions(user.getRole());
		userDTO.setPermissions(userPermission.getPermissions());

		return ResponseEntity.ok(userDTO);
	}
}
