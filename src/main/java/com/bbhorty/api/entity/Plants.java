package com.bbhorty.api.entity;

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

    private Date start_specific_plating;

    private Date end_specific_plating;

    private String src_img;



}
