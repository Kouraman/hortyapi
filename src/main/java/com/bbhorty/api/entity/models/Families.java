package com.bbhorty.api.entity.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "families")
@Data
public class Families implements Serializable {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Categories categories;

    private String name;

    private String pathName;

    private String srcImg;



}
