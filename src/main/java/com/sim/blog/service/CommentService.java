package com.sim.blog.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sim.blog.model.Comment;
import com.sim.blog.repository.CommentRepository;

import jakarta.transaction.Transactional;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	// read
	public List<Comment> getAllCommentsOfPost(Long postId) {
		return commentRepository.findByPostId(postId);
	}
	
	// create
	@Transactional
	public Comment addComment(Comment comment) {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		comment.setTime(timestamp);
		return commentRepository.save(comment);
	}
	
	// update
	@Transactional
	public Comment updateComment(Comment comment) {
		Comment editedComment = commentRepository.findById(comment.getId()).get();
		editedComment.setComment(comment.getComment());
		Timestamp timestamp = new Timestamp(new Date().getTime());
		editedComment.setTime(timestamp);
		return commentRepository.save(editedComment);
	}
}
