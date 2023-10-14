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
public class Developer extends User {
    private String description;
    private String urlCv ;

    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL)
    private List<Experience> experiences;

    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL)
    private List<Education> educations;

    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL)
    private List<Project> projects;


    @JsonManagedReference
    @OneToMany(mappedBy = "developer")
    private List<NiveauOfSkillDeveloper> niveauOfSkillDevelopers;


    @JsonManagedReference
    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL)
    private List<DevSocialNetwork> devsocialNetworks;



}
