package com.bbhorty.api.entity.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plants_images")
@Data
public class Image {

    @Id
    private Long id;

    private String srcImg;
}
