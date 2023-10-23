package com.codingtech.formationcenter.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlSocialNetwork() {
        return urlSocialNetwork;
    }

    public void setUrlSocialNetwork(String urlSocialNetwork) {
        this.urlSocialNetwork = urlSocialNetwork;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public SocialNetwork getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(SocialNetwork socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

}