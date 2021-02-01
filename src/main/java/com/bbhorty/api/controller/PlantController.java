package com.bbhorty.api.controller;

import com.bbhorty.api.entity.dto.PlantDTO;
import com.bbhorty.api.entity.models.Advice;
import com.bbhorty.api.entity.models.Image;
import com.bbhorty.api.entity.models.Price;
import com.bbhorty.api.entity.models.Treatment;
import com.bbhorty.api.services.PlantService;
import com.bbhorty.api.utils.EnvironmentVariable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/catalogue")
@RequiredArgsConstructor
@CrossOrigin
public class PlantController {

    @Autowired
    PlantService plantService;

    @GetMapping(path="/"+ EnvironmentVariable.PLANT_URI+"/{plantId}")
    public PlantDTO getPlant (
            @PathVariable int plantId
    )
    {
        return plantService.getPlant(plantId);
    }

//    @GetMapping(path="/prices/{priceId}")
//    public Price getPriceById (
//            @PathVariable int priceId
//    )
//    {
//        return plantService.getPriceById(priceId);
//    }
//
//    @GetMapping(path="/"+EnvironmentVariable.PLANT_URI+"/{plantId}/prices")
//    public Collection<Price> getPlantsPrices (
//            @PathVariable int plantId
//    )
//    {
//        return plantService.getPricesByPlantId(plantId);
//    }
//
//    @GetMapping(path="/advice/{adviceId}")
//    public Advice getAdviceById (
//            @PathVariable int adviceId
//    )
//    {
//        return plantService.getAdviceById(adviceId);
//    }
//
//    @GetMapping(path="/"+EnvironmentVariable.PLANT_URI+"/{plantId}/advices")
//    public Collection<Advice> getPlantsAdvices (
//            @PathVariable int plantId
//    )
//    {
//        return plantService.getAdvicesByPlantId(plantId);
//    }
//
//    @GetMapping(path="/treatment/{treatmentId}")
//    public Treatment getTreatment (
//            @PathVariable int treatmentId
//    )
//    {
//        return plantService.getTreatmentById(treatmentId);
//    }
//
//    @GetMapping(path="/"+EnvironmentVariable.PLANT_URI+"/{plantId}/treatments")
//    public Collection<Treatment> getPlantsTreatments (
//            @PathVariable int plantId
//    )
//    {
//        return plantService.getTreatmentsByPlantId(plantId);
//    }
//
//    @GetMapping(path="/images/{imageId}")
//    public Image getImageById (
//            @PathVariable int imageId
//    )
//    {
//        return plantService.getImageById(imageId);
//    }
//
//    @GetMapping(path="/"+EnvironmentVariable.PLANT_URI+"/{plantId}/images")
//    public Collection<Image> getPlantsImages (
//            @PathVariable int plantId
//    )
//    {
//        return plantService.getImagesByPlantId(plantId);
//    }
}
