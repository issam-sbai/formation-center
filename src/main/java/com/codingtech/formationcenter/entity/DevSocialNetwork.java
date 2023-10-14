package com.codingtech.formationcenter.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "socialNetwork_id")
    private SocialNetwork socialNetwork;
}