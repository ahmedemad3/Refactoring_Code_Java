package com.refactor.code.smells.shotgunSurgery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.refactor.code.smells.shotgunSurgery.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
