package com.pranav.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pranav.blog.payloads.ApiResponse;
import com.pranav.blog.payloads.PostDto;
import com.pranav.blog.payloads.PostResponse;
import com.pranav.blog.services.PostService;

@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	private PostService postService;

	// create
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {

		PostDto createPost = postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);

	}

	// get by user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId) {
		List<PostDto> postsByUser = postService.getPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(postsByUser, HttpStatus.OK);
	}

	// get by category
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId) {
		List<PostDto> postsByUser = postService.getPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(postsByUser, HttpStatus.OK);
	}

	// get all posts
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPosts(
			@RequestParam(value = "pageNumber" , defaultValue = "0" , required = false) Integer pageNumber,
			@RequestParam(value = "pageSize" , defaultValue = "5" , required = false ) Integer pageSize) {
		PostResponse postResponse = postService.getAllPost(pageNumber,pageSize);
		return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
	}

	// get posts by id
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {
		PostDto postDto = postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
	}

	// delete post
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletPost(@PathVariable Integer postId) {
		postService.deletePost(postId);

		return new ApiResponse("post successfully deleted", true);

	}

	// delete post
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto , @PathVariable Integer postId) {
		
		PostDto updatePost = postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatePost , HttpStatus.OK);
		

	}
}
