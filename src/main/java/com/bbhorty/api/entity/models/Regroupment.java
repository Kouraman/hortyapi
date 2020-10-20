package com.bbhorty.api.entity.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "regroupments")
@Data
public class Regroupment extends Catalogue implements Serializable {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    private String name;

    private String srcImg;

    private String pathName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "regroupment_advices",
            joinColumns = @JoinColumn(name = "regroupment_id"),
            inverseJoinColumns = @JoinColumn(name = "advice_id"))
    private Set<Advice> advices;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "regroupment_treatments",
            joinColumns = @JoinColumn(name = "regroupment_id"),
            inverseJoinColumns = @JoinColumn(name = "treatment_id"))
    private Set<Treatment> treatments;


}
