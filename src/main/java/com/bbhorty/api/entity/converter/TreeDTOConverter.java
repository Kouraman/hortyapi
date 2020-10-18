package com.bbhorty.api.entity.converter;

import com.bbhorty.api.entity.models.Families;
import com.bbhorty.api.entity.dto.TreeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class TreeDTOConverter implements Function<Collection<Families>,TreeDTO> {

    @Autowired
    FamiliesConverter familiesConverter;

    @Override
    public TreeDTO apply(Collection<Families> families) {
        TreeDTO treeDTO = new TreeDTO();
        treeDTO.setFamiliesDTOs(families.stream().map(e -> familiesConverter.apply(e)).collect(Collectors.toList()));
        return treeDTO;
    }
}
