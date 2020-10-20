package com.bbhorty.api.entity.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "planting_dates")
@Data
public class PlantingDate {

    @Id
    private Long id;

    private String name;

    private Date start_planting;

    private Date end_planting;

    private Long days_until_harvest;


}
