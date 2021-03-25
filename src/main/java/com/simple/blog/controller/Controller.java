package com.simple.blog.controller;

import com.simple.blog.model.Post;
import com.simple.blog.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Controller

public class Controller {

    @Autowired
    Service service;

    @RequestMapping("/login")
    public String getLogin(){ return "login"; }

    // return all posts
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts(){

        ModelAndView modelView = new ModelAndView("posts");
        List<Post> listPosts = service.findAll();
        modelView.addObject("posts", listPosts);
        return modelView;

    }

    // return post by id
    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public ModelAndView getPost(@PathVariable("id") long id){

        ModelAndView modelView = new ModelAndView("postDetails");
        Post post = service.findById(id);
        modelView.addObject(post);

        return modelView;
    }

    @RequestMapping(value = "newpost", method = RequestMethod.GET)
    public String getPostForm(){ return "postForm"; }


    @RequestMapping(value = "newpost", method = RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes att){

        if(result.hasErrors()){
            att.addFlashAttribute("msg", "Make sure all fields are filled.");
            return "redirect:/newpost";
        }

        post.setDate(LocalDate.now());
        service.save(post);

        return "redirect:/posts";


    }





}
