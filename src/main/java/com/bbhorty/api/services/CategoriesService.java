package com.bbhorty.api.services;

import com.bbhorty.api.entity.converter.CategoriesConverter;
import com.bbhorty.api.entity.dto.CategoriesDTO;
import com.bbhorty.api.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private CategoriesConverter categoriesConverter;

    public Collection<CategoriesDTO> getCategories(){
        return categoriesRepository.findAll().stream().map(cat -> categoriesConverter.apply(cat)).collect(Collectors.toList());
    }
}
