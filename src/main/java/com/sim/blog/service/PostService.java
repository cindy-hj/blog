package com.sim.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sim.blog.model.Post;
import com.sim.blog.repository.CommentRepository;
import com.sim.blog.repository.PostRepository;

import jakarta.transaction.Transactional;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	// read
	public List<Post> retrieveAllPosts() {
		return postRepository.findAll();
	}
	
	// read
	public Post getPost(Long id) {
		return postRepository.findById(id).get();
	}
	
	// create
	@Transactional
	public Post createPost(Post post) {
		return postRepository.save(post);
	}
	
	// update
	@Transactional
	public Post updatePost(Post post) {
		Post editedPost = postRepository.findById(post.getId()).get();
		editedPost.setTitle(post.getTitle());
		editedPost.setDescription(post.getDescription());
		return postRepository.save(editedPost);
	}
	
	// delete
	@Transactional
	public void deletePost(Long id) throws Exception{
		Post post = postRepository.findById(id).get();
		if(post != null) {
			commentRepository.deleteByPostId(id);
			postRepository.deleteById(id);
		} else {
			throw new RuntimeException("Record not found");
		}
	}
}
