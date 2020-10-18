package com.bbhorty.api.entity.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Data
public abstract class Advices {
    @Id
    private long id;

    private long id_table;

    private String advice;
}
