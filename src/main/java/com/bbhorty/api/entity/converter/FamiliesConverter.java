package com.bbhorty.api.entity.converter;

import com.bbhorty.api.entity.models.Families;
import com.bbhorty.api.entity.dto.FamiliesDTO;
import org.springframework.stereotype.Component;
import java.util.function.Function;

@Component
public class FamiliesConverter implements Function<Families, FamiliesDTO> {

    @Override
    public FamiliesDTO apply(Families family) {
        FamiliesDTO dto = new FamiliesDTO();
        dto.setId((family.getId().intValue()));
        dto.setName(family.getName());
        dto.setSrcImg(family.getSrcImg());
        return dto;
    }
}
