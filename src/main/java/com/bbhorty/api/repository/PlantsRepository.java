package com.bbhorty.api.repository;

import com.bbhorty.api.entity.models.Plant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface PlantsRepository extends CatalogueRepository<Plant> {

    @Query(value = "SELECT pla FROM Plant pla WHERE pla.regroupments.id = :regroupmentId")
    Optional<Collection<Plant>> findAllByRegroupmentsId(@Param("regroupmentId") long regroupmentId);

    @Query(value = "SELECT pla FROM Plant pla WHERE pla.id = :plantId")
    Optional<Plant> findByPlantId(@Param("plantId") long plantId);
}
