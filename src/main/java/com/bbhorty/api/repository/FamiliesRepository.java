package com.bbhorty.api.repository;


import java.util.List;

import com.bbhorty.api.entity.Families;
import org.springframework.data.repository.CrudRepository;

public interface FamiliesRepository extends CrudRepository<Families, Long>{

    List<Families> findAll();

    Families findById(long id);

    Families findByName(String name);
}
