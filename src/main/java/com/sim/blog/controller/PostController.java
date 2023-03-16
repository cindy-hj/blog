package com.sim.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sim.blog.model.Post;
import com.sim.blog.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PostController {
	
	@Autowired
	private PostService postService;
	
	// read
	@GetMapping("/posts")
	public ResponseEntity<List<Post>> retrieveAllPosts() {
		log.info("retrieve all psts controller!!");
		List<Post> posts = postService.retrieveAllPosts();
		
		return new ResponseEntity<List<Post>>(posts, new HttpHeaders(), HttpStatus.OK);
	}
	
	// read
	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> retrievePostById(@PathVariable Long id) {
		log.info("retrieve post controller!");
		
		Post post = postService.getPost(id);
		
		return new ResponseEntity<Post>(post, new HttpHeaders(), HttpStatus.OK);
	}
	
	// create
	@PostMapping("/posts")
	public ResponseEntity<Post> createPost(@RequestBody Post post) {
		log.info("create post controller!");
		Post savePost = postService.createPost(post);
		
		return new ResponseEntity<Post>(savePost, new HttpHeaders(), HttpStatus.OK);
	}
	
	// update
	@PutMapping("/posts")
	public ResponseEntity<Post> updatePost(@RequestBody Post post) {
		log.info("update post controller!");
		Post updatedPost = postService.updatePost(post);
		
		return new ResponseEntity<Post>(updatedPost, new HttpHeaders(), HttpStatus.OK);
	}
	
	// delete
	@DeleteMapping("/posts/{id}")
	public HttpStatus deletePost(@PathVariable Long id) throws Exception {
		log.info("delete post controller!");
		postService.deletePost(id);
		return HttpStatus.ACCEPTED;
	}
}
