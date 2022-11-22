package com.dawudesign.springapi.controllers;

import com.dawudesign.springapi.entities.Category;
import com.dawudesign.springapi.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoriesController {
    @Autowired
    CategoryRepository repository;

    @GetMapping("/categories")
    public List<Category> read() {
        return repository.findAll();
    }

    @GetMapping("/categories/{id}")
    public Category readById(@PathVariable Long id) {
        Category category = null;
        Optional<Category> categoryOptional = repository.findById(id);
        if(categoryOptional.isPresent()) {
            category = categoryOptional.get();
        }
        return category;
    }

    @PostMapping("/categories")
    public Category create(@RequestBody Category category) {
        return repository.save(category);
    }

    @PutMapping("/categories/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category) {
        Category categoryUpdate = repository.findById(id).get();
        categoryUpdate.setTitle(category.getTitle());
        return repository.save(categoryUpdate);
    }

    @DeleteMapping("/categories/{id}")
    public boolean delete(@PathVariable Long id) {
        repository.deleteById(id);
        return true;
    }

}
