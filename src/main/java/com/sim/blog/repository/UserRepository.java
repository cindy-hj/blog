package com.sim.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sim.blog.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
