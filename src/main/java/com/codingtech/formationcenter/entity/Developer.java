package com.codingtech.formationcenter.entity;
import com.codingtech.formationcenter.entity.*;
import com.codingtech.formationcenter.security.entity.Role;
import com.codingtech.formationcenter.security.entity.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

// @ToString(exclude = {"nom", "other-column"})
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Developer extends User {
    private String description;
    private String urlCv;

    public Developer(int id, String nom, String prenom, String username, String password, Date dateNaissance, String telephone, String imagePublicId, List<Role> roles, String description, String urlCv, List<Experience> experiences, List<Education> educations, List<RendezVous> rdvs, List<Project> projects, List<NiveauOfSkillDeveloper> niveauOfSkillDevelopers, List<DevSocialNetwork> devsocialNetworks) {
        super(id, nom, prenom, username, password, dateNaissance, telephone, imagePublicId, roles);
        this.description = description;
        this.urlCv = urlCv;
        this.experiences = experiences;
        this.educations = educations;
        this.rdvs = rdvs;
        this.projects = projects;
        this.niveauOfSkillDevelopers = niveauOfSkillDevelopers;
        this.devsocialNetworks = devsocialNetworks;
    }

    public Developer(String description, String urlCv, List<Experience> experiences, List<Education> educations, List<RendezVous> rdvs, List<Project> projects, List<NiveauOfSkillDeveloper> niveauOfSkillDevelopers, List<DevSocialNetwork> devsocialNetworks) {
        this.description = description;
        this.urlCv = urlCv;
        this.experiences = experiences;
        this.educations = educations;
        this.rdvs = rdvs;
        this.projects = projects;
        this.niveauOfSkillDevelopers = niveauOfSkillDevelopers;
        this.devsocialNetworks = devsocialNetworks;
    }

    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Experience> experiences;

    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL)
    private List<Education> educations;

    @OneToMany(mappedBy = "developer")
    private List<RendezVous> rdvs;

    @JsonManagedReference(value = "projects")
    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL)
    private List<Project> projects;

    @JsonManagedReference(value = "niveauOfSkillReference")
    @OneToMany(mappedBy = "developer")
    private List<NiveauOfSkillDeveloper> niveauOfSkillDevelopers;

    @JsonManagedReference(value = "devsocialNetworks")
    @OneToMany(mappedBy = "developer")
    private List<DevSocialNetwork> devsocialNetworks;
}
