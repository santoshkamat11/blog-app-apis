package com.pranav.blog.services;

import java.util.List;

import com.pranav.blog.entities.Post;
import com.pranav.blog.payloads.PostDto;
import com.pranav.blog.payloads.PostResponse;

public interface PostService {
	
	// create
	
	PostDto createPost(PostDto postDto , Integer userId , Integer categoryId );
	
	// update
	
	PostDto updatePost(PostDto postDto , Integer postId);
	
	// delete
	void deletePost(Integer postId);
	
	
	// get all post
	PostResponse getAllPost(Integer pageNumber , Integer pageSize , String sortBy , String sortDir);
	
	// get single post
	PostDto getPostById(Integer postId);
	
	// get all posts by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	// get all posts by user
	List<PostDto> getPostsByUser(Integer userId);
	
	//search posts
	List<PostDto> searchPosts(String keyword);

}
