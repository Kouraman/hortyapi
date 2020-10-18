package com.bbhorty.api.entity.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "plants")
@Data
public class Plants implements Serializable {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="group_id", nullable=false)
    private Regroupments regroupments;

    private String name;

    private String pathName;

    private String srcImg;



}
