package com.bbhorty.api.repository;

import com.bbhorty.api.entity.models.Regroupments;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegroupmentsRepository extends CrudRepository<Regroupments, Long> {

    List<Regroupments> findAll();

    Regroupments findById(long id);

    Regroupments findByName(String name);
}
