package com.bbhorty.api.entity.models.advices;

import com.bbhorty.api.entity.models.Advices;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "plants_treatments")
public class PlantTreatments  {

    @Id
    private long id;

    private long family_id;

    private String treatment;
}
