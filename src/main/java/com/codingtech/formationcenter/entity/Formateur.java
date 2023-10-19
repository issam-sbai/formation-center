package com.codingtech.formationcenter.entity;

import com.codingtech.formationcenter.security.entity.Role;
import com.codingtech.formationcenter.security.entity.User;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Formateur extends User {

    public Formateur(int id, String nom, String prenom, String username, String password, Date dateNaissance, String telephone, List<Role> roles) {
        super(id, nom, prenom, username, password, dateNaissance, telephone, roles);
    }

    public Formateur() {
    }
}
