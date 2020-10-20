package com.bbhorty.api.entity.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "plants")
@Data
public class Plant extends Catalogue implements Serializable {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "regroupment_id", nullable = false)
    private Regroupment regroupments;

    private String name;

    private String srcImg;

    private String description;

    private String pathName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "plants_prices",
            joinColumns = @JoinColumn(name = "plant_id"),
            inverseJoinColumns = @JoinColumn(name = "price_id"))
    private Collection<Price> prices;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "plant_advices",
            joinColumns = @JoinColumn(name = "plant_id"),
            inverseJoinColumns = @JoinColumn(name = "advice_id"))
    private Set<Advice> advices;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "plant_treatments",
            joinColumns = @JoinColumn(name = "plant_id"),
            inverseJoinColumns = @JoinColumn(name = "treatment_id"))
    private Set<Treatment> treatments;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "plant_id")
    private Collection<Image> images;
}
