package com.codingtech.formationcenter.security.dao2;



import com.codingtech.formationcenter.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;





public interface IRoleDao extends JpaRepository<Role, Integer> {

    public Role findRoleByNom(String namRole);

}
