package com.mockuptest.mockuptest;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mockuptest.mockuptest.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
