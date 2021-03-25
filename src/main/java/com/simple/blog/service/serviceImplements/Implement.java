package com.simple.blog.service.serviceImplements;

import com.simple.blog.model.Post;
import com.simple.blog.repository.SimpleBlog;
import com.simple.blog.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Implement  implements Service {

    @Autowired
    SimpleBlog repository;


    @Override
    public List<Post> findAll() {
        return repository.findAll();
    }

    @Override
    public Post findById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return repository.save(post);
    }
}
