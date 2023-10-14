package com.codingtech.formationcenter.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skillName;

    @OneToMany(mappedBy = "skill")
    @JsonManagedReference
    private List<NiveauOfSkillDeveloper> niveauOfSkillDevelopers;


    // constructors, getters, and setters
}