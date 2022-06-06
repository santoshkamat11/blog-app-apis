package com.pranav.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.blog.entities.Comment;
import com.pranav.blog.entities.Post;
import com.pranav.blog.exceptions.ResourceNotFoundException;
import com.pranav.blog.payloads.CommentDto;
import com.pranav.blog.repositories.CommentRepo;
import com.pranav.blog.repositories.PostRepo;
import com.pranav.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		
		Post post = postRepo.findById(postId).orElseThrow(()->  new ResourceNotFoundException("Post", "Post Id", postId));
		Comment comment = modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savedComment = commentRepo.save(comment);
		return modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment com = commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "Comment Id", commentId));
		commentRepo.delete(com);
	}

}
