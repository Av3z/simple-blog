package com.simple.blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name="tb_posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    @NotBlank
    @Lob
    private String description;


    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return  this.title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return this.author; }
    public void setAuthor(String author) {this.author = author; }

    public LocalDate getDate() { return this.date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getDescription() { return description; }
    public void setDescription(String description){ this.description = description;}


}
