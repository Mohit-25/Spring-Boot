package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Bean.UserBean;
import com.Dao.UserDao;

@RestController
public class SessionController {

	@Autowired
	UserDao userdao;
	
	@RequestMapping(method = RequestMethod.POST,value = "/signup")
	public UserBean SignUp(@RequestBody UserBean user)
	{
		userdao.addUser(user);
		return user;
	}
	
	
	
	
}
