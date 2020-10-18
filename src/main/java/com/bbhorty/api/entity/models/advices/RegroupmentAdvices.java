package com.bbhorty.api.entity.models.advices;

import com.bbhorty.api.entity.models.Advices;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "regroupment_advice")
class RegroupmentAdvices {

    @Id
    private long id;

    private long family_id;

    private String advice;
}
