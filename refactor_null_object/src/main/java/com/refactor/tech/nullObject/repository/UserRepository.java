package com.refactor.tech.nullObject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.refactor.tech.nullObject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
