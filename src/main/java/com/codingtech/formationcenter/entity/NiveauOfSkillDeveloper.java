package com.codingtech.formationcenter.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class NiveauOfSkillDeveloper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String niveauOfSkillDeveloper ;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    @JsonBackReference(value = "niveauOfSkillReference")
    private Developer developer;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
}
