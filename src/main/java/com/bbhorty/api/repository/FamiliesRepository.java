package com.bbhorty.api.repository;

import com.bbhorty.api.entity.models.Families;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface FamiliesRepository extends CrudRepository<Families, Long>{

    @Query(value = "SELECT fam FROM Families fam WHERE fam.categories.name LIKE :categoryName")
    Optional<Collection<Families>> findAllByCategoriesName(@Param("categoryName") String categoryName);
}
