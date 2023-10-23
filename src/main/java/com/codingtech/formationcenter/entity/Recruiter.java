package com.codingtech.formationcenter.entity;


import com.codingtech.formationcenter.security.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recruiter extends User {

    @OneToMany(mappedBy = "recruiter")
    private List<RendezVous> rendezVous;


}