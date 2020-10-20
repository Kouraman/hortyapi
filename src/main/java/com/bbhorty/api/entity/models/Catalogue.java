package com.bbhorty.api.entity.models;

import lombok.Data;

@Data
public abstract class Catalogue {

    private Long id;

    private String name;

    private String srcImg;
}
