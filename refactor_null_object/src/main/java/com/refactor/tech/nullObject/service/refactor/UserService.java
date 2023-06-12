package com.refactor.tech.nullObject.service.refactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.refactor.tech.nullObject.model.NullUser;
import com.refactor.tech.nullObject.model.User;
import com.refactor.tech.nullObject.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final User NULL_USER = new NullUser();

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(NULL_USER);
    }
}


