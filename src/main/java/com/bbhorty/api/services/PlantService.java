package com.bbhorty.api.services;

import com.bbhorty.api.entity.converter.PlantConverter;
import com.bbhorty.api.entity.dto.PlantDTO;
import com.bbhorty.api.entity.models.*;
import com.bbhorty.api.exception.ResourceNotFoundException;
import com.bbhorty.api.repository.PlantsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class PlantService {

    @Autowired
    PlantsRepository plantsRepository;

    @Autowired
    PlantConverter plantConverter;

    public PlantDTO getPlant(int plantId) {

        Plant plant = plantsRepository.findByPlantId(plantId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found plant for the id  : " + plantId));

        return plantConverter.apply(plant);

    }


//    public Price getPriceById(int priceId) {
//    }
//
//    public Collection<Price> getPricesByPlantId(int plantId) {
//    }
//
//    public Advice getAdviceById(int adviceId) {
//    }
//
//    public Collection<Advice> getAdvicesByPlantId(int plantId) {
//    }
//
//    public Treatment getTreatmentById(int treatmentId) {
//    }
//
//    public Collection<Treatment> getTreatmentsByPlantId(int plantId) {
//    }
//
//    public Image getImageById(int imageId) {
//    }
//
//    public Collection<Image> getImagesByPlantId(int plantId) {
//    }
}