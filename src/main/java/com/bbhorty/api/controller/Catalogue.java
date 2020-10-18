package com.bbhorty.api.controller;

import com.bbhorty.api.entity.dto.CategoriesDTO;
import com.bbhorty.api.entity.dto.TreeDTO;
import com.bbhorty.api.repository.PlantsRepository;
import com.bbhorty.api.services.CategoriesService;
import com.bbhorty.api.services.FamiliesService;
import com.bbhorty.api.services.RegroupmentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/catalogue")
@RequiredArgsConstructor
@Slf4j
class Catalogue {

    @Autowired
    private CategoriesService categoriesService;

    @Autowired
    private FamiliesService familiesService;

    @Autowired
    private RegroupmentsService regroupmentsService;

    @Autowired
    private PlantsRepository plantsRepository;

    @RequestMapping(path="")
    public Collection<CategoriesDTO> getCategories(){
        return categoriesService.getCategories();
    }

    @RequestMapping(path="/{category}")
    public TreeDTO getFamiliesCatalogue( @PathVariable String category){
        return familiesService.getTree(category);
    }

    @RequestMapping(path="/{category}/{family}")
    public TreeDTO getPlantCatalogue(@PathVariable String category,
                                     @PathVariable String family)
    {
        return null;
    }

    @RequestMapping(path="/{category}/{family}/{plantId}")
    public TreeDTO getPlant(@PathVariable String category,
                            @PathVariable String family,
                            @PathVariable String plantId)
    {
        return null;
    }

    // Example endpoint : {category}/{family}/{plantId}

}