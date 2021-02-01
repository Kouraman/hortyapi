package com.bbhorty.api.controller;

import com.bbhorty.api.entity.dto.CatalogueDTO;
import com.bbhorty.api.entity.dto.PlantDTO;
import com.bbhorty.api.services.CatalogueService;
import com.bbhorty.api.utils.EnvironmentVariable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/"+EnvironmentVariable.CATALOGUE_URI)
@RequiredArgsConstructor
@CrossOrigin
class CatalogueController {

    @Autowired
    private CatalogueService catalogueService;

    @GetMapping(path="")
    public Collection<CatalogueDTO> getCategoriesCatalogue(){
        return catalogueService.getCategories();

    }

    @GetMapping(path="/"+ EnvironmentVariable.CATEGORY_URI +"/{categoryId}")
    public Collection<CatalogueDTO> getCategory (
            @PathVariable int categoryId
    )
    {
        return catalogueService.getFamilies(categoryId);
    }

    @GetMapping(path="/"+EnvironmentVariable.FAMILY_URI+"/{familyId}")
    public Collection<CatalogueDTO> getFamily (
            @PathVariable int familyId
    )
    {
        return catalogueService.getRegroupments(familyId);
    }

    @GetMapping(path="/"+EnvironmentVariable.REGROUPMENT_URI+"/{regroupmentId}")
    public Collection<CatalogueDTO> getRegroupment (
            @PathVariable int regroupmentId
    )
    {
        return catalogueService.getPlants(regroupmentId);
    }
}