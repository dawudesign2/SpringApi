package com.dawudesign.springapi.controllers;

import com.dawudesign.springapi.entities.Category;
import com.dawudesign.springapi.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/categories")
public class CategoriesController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> read() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Category readById(@PathVariable Long id) {
        Category category = null;
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()) {
            category = categoryOptional.get();
        }
        return category;
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category) {
        Category categoryUpdate = categoryRepository.findById(id).get();
        categoryUpdate.setTitle(category.getTitle());
        return categoryRepository.save(categoryUpdate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        categoryRepository.deleteById(id);
        return true;
    }

}
