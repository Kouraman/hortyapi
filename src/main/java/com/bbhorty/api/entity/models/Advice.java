package com.bbhorty.api.entity.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "advices")
public class Advice {

    @Id
    private Long id;

    private String name;

    private String advice;
}
