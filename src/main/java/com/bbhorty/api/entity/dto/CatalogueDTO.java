package com.bbhorty.api.entity.dto;

import com.bbhorty.api.entity.models.Catalogue;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CatalogueDTO extends Catalogue {

    private String pathName;
}
