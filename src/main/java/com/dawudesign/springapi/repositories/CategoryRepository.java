package com.dawudesign.springapi.repositories;

import com.dawudesign.springapi.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
