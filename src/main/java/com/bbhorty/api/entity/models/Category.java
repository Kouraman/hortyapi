package com.bbhorty.api.entity.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "categories")
@Data
public class Category extends Catalogue {

    @Id
    private Long id;

    private String name;

    private String srcImg;

}
