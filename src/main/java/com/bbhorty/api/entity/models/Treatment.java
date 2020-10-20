package com.bbhorty.api.entity.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "treatments")
public class Treatment {

    @Id
    private Long id;

    private String treatment;

    private String name;

}
