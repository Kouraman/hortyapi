package com.bbhorty.api.entity.converter;

import com.bbhorty.api.entity.dto.PlantDTO;
import com.bbhorty.api.entity.models.Advice;
import com.bbhorty.api.entity.models.Plant;
import com.bbhorty.api.entity.models.Treatment;
import com.bbhorty.api.utils.ApiUrlMaker;
import com.bbhorty.api.utils.CdnUrlMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

@Component
public class PlantConverter implements Function<Plant, PlantDTO> {

    @Autowired
    CdnUrlMaker cdnUrlMaker;

    @Autowired
    ApiUrlMaker apiUrlMaker;

    @Override
    public PlantDTO apply(Plant plant) {
        PlantDTO dto = new PlantDTO();
        dto.setId(plant.getId());
        dto.setName(StringUtils.capitalize(plant.getName()));
        dto.setPathName(apiUrlMaker.getPath(plant));
        dto.setImg(cdnUrlMaker.setImgPath(plant));
        dto.setDescription(plant.getDescription());
        dto.setPrices(plant.getPrices());

        dto.addAdvices(getAdvices(plant));
        dto.addTreatments(getTreatments(plant));

        return dto;
    }

    private Collection<Advice> getAdvices(Plant plant) {
        Collection<Advice> advices = new ArrayList<>();

        advices.addAll(plant.getAdvices());
        advices.addAll(plant.getRegroupments().getAdvices());
        advices.addAll(plant.getRegroupments().getFamily().getAdvices());

        return advices;

    }

    private Collection<Treatment> getTreatments(Plant plant) {

        Collection<Treatment> treatments = new ArrayList<>();

        treatments.addAll(plant.getTreatments());
        treatments.addAll(plant.getRegroupments().getTreatments());
        treatments.addAll(plant.getRegroupments().getFamily().getTreatments());

        return treatments;

    }
}
