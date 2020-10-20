package com.bbhorty.api.entity.dto;

import com.bbhorty.api.entity.models.Advice;
import com.bbhorty.api.entity.models.Image;
import com.bbhorty.api.entity.models.Price;
import com.bbhorty.api.entity.models.Treatment;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class PlantDTO {

    long id;

    String name;

    String pathName;

    String description;

    Collection<Image> img;

    Collection<Price> prices;

    @Setter(AccessLevel.NONE)
    Collection<Advice> advices;

    @Setter(AccessLevel.NONE)
    Collection<Treatment> treatments;

    public void addAdvices(Advice advice) {
        checkNotInitialized();
        advices.add(advice);
    }

    public void addAdvices(Collection<Advice> advices) {
        checkNotInitialized();
        this.advices.addAll(advices);
    }

    public void addTreatments(Treatment treatment) {
        checkNotInitialized();
        treatments.add(treatment);
    }

    public void addTreatments(Collection<Treatment> treatments) {
        checkNotInitialized();
        this.treatments.addAll(treatments);
    }

    private void checkNotInitialized() {
        if (this.advices == null) this.advices = new ArrayList<>();
        if (this.treatments == null) this.treatments = new ArrayList<>();
    }

}
