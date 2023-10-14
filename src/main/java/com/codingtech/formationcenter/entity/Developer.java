package com.codingtech.formationcenter.entity;


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

    @ManyToMany
    @JoinTable(
            name = "developer_skill",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;

    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL)
    private List<SocialNetwork> socialNetworks;


}
