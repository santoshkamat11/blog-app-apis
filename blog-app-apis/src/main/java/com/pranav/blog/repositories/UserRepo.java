package com.pranav.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranav.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}