package com.bbhorty.api.services;

import com.bbhorty.api.entity.Plants;
import com.bbhorty.api.entity.Regroupments;
import com.bbhorty.api.repository.PlantsRepository;
import com.bbhorty.api.repository.RegroupmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PlantsService {

    @Autowired
    private PlantsRepository plantsRepository;

    public Plants getById(int id){
        return plantsRepository.findById(id);
    }
}
