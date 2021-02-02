package com.bbhorty.api.entity.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prices")
@Data
public class Price {

    @Id
    private Long id;

    private String name;

    private Float price;

    private Long quantity;

}
