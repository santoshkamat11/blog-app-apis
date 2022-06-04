package com.pranav.blog.services;

import java.util.List;

import com.pranav.blog.entities.Post;
import com.pranav.blog.payloads.PostDto;

public interface PostService {
	
	// create
	
	PostDto createPost(PostDto postDto , Integer userId , Integer categoryId );
	
	// update
	
	Post updatePost(PostDto postDto , Integer postId);
	
	// delete
	void deletePost(Integer postId);
	
	
	// get all post
	List<Post> getAllPost();
	
	// get single post
	Post getPostById(Integer postId);
	
	// get all posts by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	// get all posts by user
	List<PostDto> getPostsByUser(Integer userId);
	
	//search posts
	List<Post> searchPosts(String keyword);

}
