package com.codingtech.formationcenter.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Date date_dube;
    private Date date_fin;

    @ManyToMany(mappedBy = "promotions")
    private List<Formateur> formateurs;

    @OneToMany(mappedBy = "promotion")
    private List<Module> modules;



}