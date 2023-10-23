package com.codingtech.formationcenter.security.dao2;






import com.codingtech.formationcenter.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;





public interface IUserDao extends JpaRepository<User, Integer> {
	
	
	public User findByUsername(String username);

}
