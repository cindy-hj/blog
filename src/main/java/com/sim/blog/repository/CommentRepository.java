package com.sim.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sim.blog.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	void deleteByPostId(Long id);

	List<Comment> findByPostId(Long postId);

}
