package com.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Bean.UserBean;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate stmt;
	
	public void addUser(UserBean user)
	{
		String insertUser="insert into users (firstName,lastName,emailId,password,gender) values(?,?,?,?,?)";
		
		stmt.update(insertUser,user.getFirstName(),user.getLastName(),user.getEmailId(),user.getPassword(),user.getGender());
	
	}

}
