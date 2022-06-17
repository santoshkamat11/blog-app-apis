package com.pranav.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pranav.blog.entities.User;
import com.pranav.blog.exceptions.ResourceNotFoundException;
import com.pranav.blog.repositories.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// loading user from data base by username
		User user = userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User ", " email : "+username, 0));
		return user;
	}

}
