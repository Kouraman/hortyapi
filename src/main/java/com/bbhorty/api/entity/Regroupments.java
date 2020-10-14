package com.bbhorty.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "regroupments")
@Data
public class Regroupments implements Serializable {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="family_id", nullable=false)
    private Families family;

    private String name;

    private Date start_plating;

    private Date end_plating;


}
