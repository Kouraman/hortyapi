package com.bbhorty.api.repository;

import com.bbhorty.api.entity.models.Regroupment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface RegroupmentsRepository extends CatalogueRepository<Regroupment> {

    @Query(value = "SELECT grp FROM Regroupment grp WHERE grp.family.id = :familyId")
    Optional<Collection<Regroupment>> findAllByFamilyId(@Param("familyId") long familyId);
}
