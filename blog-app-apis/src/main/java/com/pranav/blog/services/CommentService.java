package com.pranav.blog.services;

import com.pranav.blog.payloads.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto , Integer postId);
	
	void deleteComment(Integer commentId);

}
