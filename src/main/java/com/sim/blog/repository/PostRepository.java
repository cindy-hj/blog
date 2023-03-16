package com.sim.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sim.blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
