package com.codingtech.formationcenter.security.service;


import com.codingtech.formationcenter.security.dao2.IUserDao;
import com.codingtech.formationcenter.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class UserService implements IuserService {
	
	@Autowired
	IUserDao userDao;
	
	public User chercherparUsername(String username)
	{
		return userDao.findByUsername(username);
	}

}
