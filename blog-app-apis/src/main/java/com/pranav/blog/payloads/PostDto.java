package com.pranav.blog.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.pranav.blog.entities.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
	
	private Integer postId;
	
	private String title;
	
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	//else recursion occurs
	private CategoryDto category;
	
	//else recursion occurs
	private UserDto user;
	
	private Set<CommentDto> comments = new HashSet<>();

}
