package com.sim.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sim.blog.model.Comment;
import com.sim.blog.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CommentController {
	@Autowired
	private CommentService commentService;

	// read
	@GetMapping("/comments/{postId}")
	public ResponseEntity<List<Comment>> retrieveAllCommentsOfPost(@PathVariable Long postId) {
		log.info("retrieve all comments of post!");
		List<Comment> comments = commentService.getAllCommentsOfPost(postId);
		return new ResponseEntity<List<Comment>>(comments, new HttpHeaders(), HttpStatus.OK);
	}
	
	// create 
	@PostMapping("/comments")
	public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
		log.info("add comment controller");
		Comment savedComment = commentService.addComment(comment);
		return new ResponseEntity<Comment>(savedComment, new HttpHeaders(), HttpStatus.OK);
	}
	
	// update
	@PutMapping("/comments")
	public ResponseEntity<Comment> updateComment(@RequestBody Comment comment) {
		log.info("update comment controller");
		Comment updatedComment = commentService.updateComment(comment); // 수정 완료
		return new ResponseEntity<Comment>(updatedComment, new HttpHeaders(), HttpStatus.ACCEPTED);
	}
}
