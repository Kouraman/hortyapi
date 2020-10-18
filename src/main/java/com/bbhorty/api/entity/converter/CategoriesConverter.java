package com.bbhorty.api.entity.converter;

import com.bbhorty.api.entity.models.Categories;
import com.bbhorty.api.entity.dto.CategoriesDTO;
import org.springframework.stereotype.Component;
import java.util.function.Function;

@Component
public class CategoriesConverter implements Function<Categories, CategoriesDTO> {

    @Override
    public CategoriesDTO apply(Categories categories) {
        CategoriesDTO dto = new CategoriesDTO();
        dto.setName(categories.getName());
        dto.setSrcImg(categories.getSrcImg());
        return dto;
    }
}
