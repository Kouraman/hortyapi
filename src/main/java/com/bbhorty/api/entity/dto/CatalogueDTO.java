package com.bbhorty.api.entity.dto;

import com.bbhorty.api.entity.models.Catalogue;
import lombok.Data;

@Data
public class CatalogueDTO extends Catalogue {

    private String pathName;
}
