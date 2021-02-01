package com.bbhorty.api.services;

import com.bbhorty.api.entity.converter.CatalogueConverter;
import com.bbhorty.api.entity.converter.PlantConverter;
import com.bbhorty.api.entity.dto.CatalogueDTO;
import com.bbhorty.api.entity.dto.PlantDTO;
import com.bbhorty.api.entity.models.Plant;
import com.bbhorty.api.exception.ResourceNotFoundException;
import com.bbhorty.api.repository.CategoriesRepository;
import com.bbhorty.api.repository.FamiliesRepository;
import com.bbhorty.api.repository.PlantsRepository;
import com.bbhorty.api.repository.RegroupmentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatalogueService {

    @Autowired
    private CatalogueConverter catalogueConverter;
    @Autowired
    private PlantConverter plantConverter;

    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private FamiliesRepository familiesRepository;
    @Autowired
    private RegroupmentsRepository regroupmentsRepository;
    @Autowired
    private PlantsRepository plantsRepository;


    public Collection<CatalogueDTO> getCategories(){
        return categoriesRepository.findAll()
                .stream()
                .map(category -> catalogueConverter.apply(category))
                .collect(Collectors.toList());
    }

    public Collection<CatalogueDTO> getFamilies(int categoryId){

        return familiesRepository.findAllByFamilyId((long) categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found families for the id  : "+categoryId))
                .stream()
                .map(family -> catalogueConverter.apply(family))
                .collect(Collectors.toList());
    }

    public Collection<CatalogueDTO> getRegroupments(int familyId){

        return regroupmentsRepository.findAllByFamilyId((long) familyId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found regroupments for the id  : "+familyId))
                .stream()
                .map(grp -> catalogueConverter.apply(grp))
                .collect(Collectors.toList());
    }

    public Collection<CatalogueDTO> getPlants(int regroupmentId){

        return plantsRepository.findAllByRegroupmentsId(regroupmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found plants for the id  : "+regroupmentId))
                .stream()
                .map(grp -> catalogueConverter.apply(grp))
                .collect(Collectors.toList());
    }
}
