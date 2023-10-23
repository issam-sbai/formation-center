package com.codingtech.formationcenter.repo;

import com.codingtech.formationcenter.entity.Skill;
import com.codingtech.formationcenter.entity.SocialNetwork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SocialNetworkRepo  extends JpaRepository<SocialNetwork,Long> {

    List<SocialNetwork> findSocialNetworkByNetworkName(String networkName);
    SocialNetwork findByNetworkName(String networkName);
}
