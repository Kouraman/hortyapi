package com.bbhorty.api.repository;

import com.bbhorty.api.entity.models.Families;
import com.bbhorty.api.entity.models.Plants;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface PlantsRepository extends CrudRepository<Plants, Long> {

    List<Plants> findAll();

    Plants findById(long id);

    Plants findByName(String name);

    @Query(value = "SELECT pla FROM Plants pla WHERE pla.regroupments.name LIKE :categoryName")
    Optional<Collection<Families>> findAllByCategoriesName(@Param("categoryName") String categoryName);
}
