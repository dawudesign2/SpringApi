package com.dawudesign.springapi.controllers;

import com.dawudesign.springapi.entities.Article;
import com.dawudesign.springapi.repositories.ArticleRepository;
import com.dawudesign.springapi.repositories.CategoryRepository;
import com.dawudesign.springapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/articles")
public class ArticlesController {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping
    public List<Article> read(){ return articleRepository.findAll(); }

    @GetMapping("/id")
    public Article readById(@PathVariable Long id) {
        Article article = null;
        Optional<Article> articleOptional = articleRepository.findById(id);
        if (articleOptional.isPresent()) {
            article = articleOptional.get();
        }
        return article;
    }

    @PostMapping
    public Article create(@RequestBody Article article){
        return articleRepository.save(article);
    }

    @PutMapping("/id")
    public Article update(@PathVariable Long id, @RequestBody Article article) {
        Article articleUpdate = articleRepository.findById(id).get();
        articleUpdate.setTitle(article.getTitle());
        articleUpdate.setContent(article.getContent());
        return articleRepository.save(articleUpdate);
    }

    @DeleteMapping("/id")
    public Boolean delete(@PathVariable Long id) {
        articleRepository.deleteById(id);
        return true;
    }

}
