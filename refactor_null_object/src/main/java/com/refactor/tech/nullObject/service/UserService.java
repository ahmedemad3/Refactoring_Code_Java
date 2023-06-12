package com.refactor.tech.nullObject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.refactor.tech.nullObject.model.User;
import com.refactor.tech.nullObject.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    /**
     *  As you can see, the getUserById method returns null if the user is not found in the database. To avoid the risk of null pointer exceptions, 
     *  we can refactor the code to use a NullUser object instead.
     */
}

