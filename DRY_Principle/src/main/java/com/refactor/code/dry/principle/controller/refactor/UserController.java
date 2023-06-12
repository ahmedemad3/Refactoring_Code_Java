package com.refactor.code.dry.principle.controller.refactor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.refactor.code.dry.principle.model.User;

@RestController
@RequestMapping("/users")
public class UserController extends CrudController<User, Long>{

    // no need to repeat CRUD methods here
}
