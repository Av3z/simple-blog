package com.simple.blog.service;

import com.simple.blog.model.Post;

import java.util.List;

public interface Service {

    List<Post> findAll();
    Post findById(long id);
    Post save(Post post);

}
