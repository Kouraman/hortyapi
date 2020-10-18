package com.bbhorty.api.services;

import com.bbhorty.api.entity.models.Plants;
import com.bbhorty.api.repository.PlantsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PlantsService {

    @Autowired
    private PlantsRepository plantsRepository;

    public Plants getById(int id){
        return plantsRepository.findById(id);
    }
}
