package com.pranav.blog.payloads;

import java.util.Date;

import com.pranav.blog.entities.Category;
import com.pranav.blog.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
	
	private String title;
	
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	//else recursion occurs
	private CategoryDto category;
	
	//else recursion occurs
	private UserDto user;

}
