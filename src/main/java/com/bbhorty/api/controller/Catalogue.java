package com.bbhorty.api.controller;

import com.bbhorty.api.entity.dto.CatalogueDTO;
import com.bbhorty.api.entity.dto.PlantDTO;
import com.bbhorty.api.services.CatalogueService;
import com.bbhorty.api.utils.EnvironmentVariable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/"+EnvironmentVariable.CATALOGUE_URI)
@RequiredArgsConstructor
@Slf4j
class Catalogue {

    @Autowired
    private CatalogueService catalogueService;

    @RequestMapping(path="")
    public Collection<CatalogueDTO> getCategoriesCatalogue(){
        return catalogueService.getCategories();

    }

    @RequestMapping(path="/"+ EnvironmentVariable.CATEGORY_URI +"/{categoryId}")
    public Collection<CatalogueDTO> getCategory (
            @PathVariable int categoryId
    )
    {
        return catalogueService.getFamilies(categoryId);
    }

    @RequestMapping(path="/"+EnvironmentVariable.FAMILY_URI+"/{familyId}")
    public Collection<CatalogueDTO> getFamily (
            @PathVariable int familyId
    )
    {
        return catalogueService.getRegroupments(familyId);
    }

    @RequestMapping(path="/"+EnvironmentVariable.REGROUPMENT_URI+"/{regroupmentId}")
    public Collection<CatalogueDTO> getRegroupment (
            @PathVariable int regroupmentId
    )
    {
        return catalogueService.getPlants(regroupmentId);
    }

    @RequestMapping(path="/"+EnvironmentVariable.PLANT_URI+"/{plantId}")
    public PlantDTO getProduct (
            @PathVariable int plantId
    )
    {
        return catalogueService.getPlant(plantId);
    }
}