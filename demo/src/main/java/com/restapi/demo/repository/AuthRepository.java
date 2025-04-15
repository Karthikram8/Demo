package com.restapi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.demo.model.User;

public interface AuthRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username); 

}
