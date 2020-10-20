package com.bbhorty.api.entity.converter;

import com.bbhorty.api.entity.dto.CatalogueDTO;
import com.bbhorty.api.entity.models.Catalogue;
import com.bbhorty.api.utils.ApiUrlMaker;
import com.bbhorty.api.utils.CdnUrlMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.function.Function;

@Component
public class CatalogueConverter implements Function<Catalogue, CatalogueDTO> {

    @Autowired
    CdnUrlMaker cdnUrlMaker;

    @Autowired
    ApiUrlMaker apiUrlMaker;

    @Override
    public CatalogueDTO apply(Catalogue catalogue) {

        CatalogueDTO dto = new CatalogueDTO();

        dto.setId(catalogue.getId());
        dto.setName(catalogue.getName());
        dto.setSrcImg(catalogue.getSrcImg());

        dto.setName(StringUtils.capitalize(catalogue.getName()));
        dto.setPathName(apiUrlMaker.getPath(catalogue));
        dto.setSrcImg(cdnUrlMaker.getImgPath(catalogue));

        return dto;
    }
}
