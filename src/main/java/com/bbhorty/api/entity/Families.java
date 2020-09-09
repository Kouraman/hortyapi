package com.bbhorty.api.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "families")
@Data
public class Families implements Serializable {

    @Id
    private Long id;

    private String name;

    private String src_img;



}
