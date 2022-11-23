package com.dawudesign.springapi.repositories;

import com.dawudesign.springapi.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
