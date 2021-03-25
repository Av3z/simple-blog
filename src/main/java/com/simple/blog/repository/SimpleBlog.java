package com.simple.blog.repository;

import com.simple.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleBlog extends JpaRepository<Post, Long> { }
