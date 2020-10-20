package com.bbhorty.api.repository;

import com.bbhorty.api.entity.models.Catalogue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CatalogueRepository<T extends Catalogue> extends CrudRepository<T, Long> {
}
