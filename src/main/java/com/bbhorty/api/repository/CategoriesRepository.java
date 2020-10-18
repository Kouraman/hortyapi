package com.bbhorty.api.repository;

import com.bbhorty.api.entity.models.Categories;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface CategoriesRepository extends CrudRepository<Categories, Long> {

    Collection<Categories> findAll();

    Categories findById(long id);

    Categories findByName(String name);
}
