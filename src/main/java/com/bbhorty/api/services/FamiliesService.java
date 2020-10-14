package com.bbhorty.api.services;

import com.bbhorty.api.entity.Families;
import com.bbhorty.api.entity.converter.TreeDTOConverter;
import com.bbhorty.api.entity.dto.TreeDTO;
import com.bbhorty.api.exception.ResourceNotFoundException;
import com.bbhorty.api.repository.FamiliesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.tree.Tree;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FamiliesService {

    @Autowired
    private FamiliesRepository familiesRepository;

    @Autowired
    private TreeDTOConverter treeDTOConverter;

    public TreeDTO getTree(String categoryName){

        Collection<Families> fams = familiesRepository.findAllByCategoriesName(categoryName)
                .orElseThrow(() -> new ResourceNotFoundException("Category : "+categoryName+" was not found"));

        TreeDTO tree = treeDTOConverter.apply(fams);
        tree.setCategoryName(categoryName);



        return tree;

    }
}
