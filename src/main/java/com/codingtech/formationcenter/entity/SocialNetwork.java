package com.codingtech.formationcenter.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SocialNetwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String networkName;
    private String urlNetwork;


    @OneToMany(mappedBy = "socialNetwork")
    @JsonIgnore
    private List<DevSocialNetwork> devSocialNetworks;
}
