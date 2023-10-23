package com.codingtech.formationcenter.entity;
import com.codingtech.formationcenter.entity.*;
import com.codingtech.formationcenter.security.entity.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

// @ToString(exclude = {"nom", "other-column"})
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Developer extends User {
    private String description;
    private String urlCv;

    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Experience> experiences;

    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL)
    private List<Education> educations;

    @OneToMany(mappedBy = "developer")
    private List<RendezVous> rdvs;

    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL)
    private List<Project> projects;

    @JsonManagedReference(value = "niveauOfSkillReference")
    @OneToMany(mappedBy = "developer")
    private List<NiveauOfSkillDeveloper> niveauOfSkillDevelopers;

    @JsonManagedReference(value = "devsocialNetworks")
    @OneToMany(mappedBy = "developer")
    private List<DevSocialNetwork> devsocialNetworks;
}