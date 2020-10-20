package com.bbhorty.api.repository;

import com.bbhorty.api.entity.models.Category;

import java.util.Collection;

public interface CategoriesRepository extends CatalogueRepository<Category>{

    Collection<Category> findAll();
}
