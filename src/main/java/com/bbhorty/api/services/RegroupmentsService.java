package com.bbhorty.api.services;

import com.bbhorty.api.entity.Families;
import com.bbhorty.api.entity.Regroupments;
import com.bbhorty.api.repository.FamiliesRepository;
import com.bbhorty.api.repository.RegroupmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegroupmentsService {

    @Autowired
    private RegroupmentsRepository regroupmentsRepository;

    public Regroupments getById(int id){
        return regroupmentsRepository.findById(id);
    }
}
