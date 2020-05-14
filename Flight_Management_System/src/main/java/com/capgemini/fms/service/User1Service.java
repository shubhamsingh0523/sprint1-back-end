package com.capgemini.fms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.fms.dao.User1Dao;
import com.capgemini.fms.entity.User1;


@Service
@Transactional
public class User1Service {
	
	@Autowired
	User1Dao user1Dao;
	public boolean addUser1(User1 user1)
	{
		return user1Dao.save(user1) !=null;
	}
	
	public Optional<User1> shows(int user_id )
	{
		return user1Dao.findById(user_id);
	}
	
	public List<User1> show()
	{
		return user1Dao.findAll();
	}
	
	public void deleteUser1(int user_id) {

		user1Dao.deleteById(user_id);
	}
	
	public User1 updateUser1(User1 user1,int user_id) {
		
		return user1Dao.save(user1);
	}  
	 
	
}