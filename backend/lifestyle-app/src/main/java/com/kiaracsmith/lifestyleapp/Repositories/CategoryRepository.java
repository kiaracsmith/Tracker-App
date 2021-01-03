package com.kiaracsmith.lifestyleapp.Repositories;

import java.util.List;

import com.kiaracsmith.lifestyleapp.Entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Long>{
   /*List<Category> findByCategoryId(Long categoryId);

   List<Category> findByCategoryName(String categoryName);*/

}

