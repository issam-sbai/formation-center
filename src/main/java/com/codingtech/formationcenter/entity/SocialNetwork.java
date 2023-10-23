package com.codingtech.formationcenter.entity;


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
public class SocialNetwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String networkName;
    private String urlNetwork;

}
