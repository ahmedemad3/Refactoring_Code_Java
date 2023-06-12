package com.refactor.code.kiss.principle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.refactor.code.kiss.principle.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
