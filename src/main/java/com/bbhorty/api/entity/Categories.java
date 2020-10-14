package com.bbhorty.api.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "categories")
@Data
public class Categories {
    @Id
    private Long id;

    private String name;

    private String srcImg;

//    @OneToMany(mappedBy="families")
//    private Set<Families> families;
}
