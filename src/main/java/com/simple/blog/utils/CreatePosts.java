package com.simple.blog.utils;

import com.simple.blog.model.Post;
import com.simple.blog.repository.SimpleBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class CreatePosts {


    @Autowired
    SimpleBlog repository;

    //@PostConstruct
    public void savePosts(){

        List<Post> postList = new ArrayList<>();

        Post postIde = new Post();

        postIde.setAuthor("Willyan");
        postIde.setTitle("Falando sobre IDEs");
        postIde.setDate(LocalDate.now());
        postIde.setDescription("orem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu não só a cinco séculos");


        Post postEditors = new Post();

        postEditors.setTitle("Falando sobre editores de texto");
        postEditors.setDate(LocalDate.now());
        postEditors.setAuthor("Lucas");
        postEditors.setDescription("orem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu não só a cinco séculos");

        postList.add(postIde);
        postList.add(postEditors);

        for(Post post : postList){
            Post postSaved = repository.save(post);
            System.out.println(postSaved.getId());
        }

    }


}
