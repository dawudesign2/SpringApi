package com.dawudesign.springapi.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    public Category() {}

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Article> articles;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
