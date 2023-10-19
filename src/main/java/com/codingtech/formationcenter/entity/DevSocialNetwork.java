package com.codingtech.formationcenter.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DevSocialNetwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String urlSocialNetwork ;


    @ManyToOne
    @JoinColumn(name = "developer_id")
    @JsonBackReference(value = "devsocialNetworks")
    private Developer developer;


    @ManyToOne
    @JoinColumn(name = "socialNetwork_id")
    private SocialNetwork socialNetwork;
}