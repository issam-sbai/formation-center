package com.codingtech.formationcenter.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private String status;

    @ManyToMany
    @JoinTable(
            name = "promotion_formateur",
            joinColumns = @JoinColumn(name = "promotion_id"),
            inverseJoinColumns = @JoinColumn(name = "formateur_id")
    )
    private List<Formateur> formateurs;

    @ManyToMany
    @JoinTable(
            name = "promotion_developers",
            joinColumns = @JoinColumn(name = "promotion_id"),
            inverseJoinColumns = @JoinColumn(name = "developers_id")
    )
    @JsonIgnoreProperties({"experiences","niveauOfSkillDevelopers","devsocialNetworks"})
    private List<Developer> developers;

    @Transient
    private int nbrDeveloper;




}
