package com.bbhorty.api.entity.models.advices;

import com.bbhorty.api.entity.models.Advices;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "family_advices")
public class FamilyAdvices {

    @Id
    private long id;

    private long family_id;

    private String advice;
}