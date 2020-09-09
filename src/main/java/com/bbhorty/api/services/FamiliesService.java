package com.bbhorty.api.services;

import com.bbhorty.api.entity.Families;
import com.bbhorty.api.repository.FamiliesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamiliesService {

    @Autowired
    private FamiliesRepository familiesRepository;

    public Families getById(int id){
        return familiesRepository.findById(id);
    }
}
