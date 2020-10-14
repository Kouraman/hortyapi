package com.bbhorty.api.repository;

import com.bbhorty.api.entity.Categories;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface CategoriesRepository extends CrudRepository<Categories, Long> {

    Collection<Categories> findAll();

    Categories findById(long id);

    Categories findByName(String name);
}
