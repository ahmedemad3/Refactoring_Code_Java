package com.refactor.code.dry.principle.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.refactor.code.dry.principle.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
