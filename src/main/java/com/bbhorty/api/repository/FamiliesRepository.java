package com.bbhorty.api.repository;

import com.bbhorty.api.entity.models.Family;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface FamiliesRepository extends CatalogueRepository<Family>{

    @Query(value = "SELECT fam FROM Family fam WHERE fam.categories.name LIKE :categoryName")
    Optional<Collection<Family>> findAllByCategoryName(@Param("categoryName") String categoryName);

    @Query(value = "SELECT fam FROM Family fam WHERE fam.categories.id = :categoryId")
    Optional<Collection<Family>> findAllByFamilyId(@Param("categoryId") long categoryId);
}
