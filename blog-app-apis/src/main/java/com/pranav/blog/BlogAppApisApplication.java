package com.pranav.blog;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pranav.blog.entities.Role;
import com.pranav.blog.repositories.RoleRepo;
import com.pranav.blog.config.AppConstants;

@SpringBootApplication
public class BlogAppApisApplication implements CommandLineRunner {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Role role1 = new Role();
		role1.setId(AppConstants.ADMIN_USER);
		role1.setName("ROLE_ADMIN");
		
		Role role2 = new Role();
		role2.setId(AppConstants.NORMAL_USER);
		role2.setName("ROLE_NORMAL");
		
		List<Role> roles = Arrays.asList(role1,role2);
		List<Role> result = roleRepo.saveAll(roles);
		
	}

}
