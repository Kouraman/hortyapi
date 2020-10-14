package com.bbhorty.api.entity.dto;

import lombok.Data;

import java.util.Collection;

@Data
public class TreeDTO {
    String categoryName;
    Collection<FamiliesDTO> familiesDTOs;
}
