package com.bbhorty.api.entity.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "families")
@Data
public class Family extends Catalogue implements Serializable {

    @Id
    private Long id;

    private String name;

    private String srcImg;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category categories;

    private String pathName;


    @ManyToMany
    @JoinTable(
            name = "family_advices",
            joinColumns = @JoinColumn(name = "family_id"),
            inverseJoinColumns = @JoinColumn(name = "advice_id"))
    private Set<Advice> advices;

    @ManyToMany
    @JoinTable(
            name = "family_treatments",
            joinColumns = @JoinColumn(name = "family_id"),
            inverseJoinColumns = @JoinColumn(name = "treatment_id"))
    private Set<Treatment> treatments;


}
