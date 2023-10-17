package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private final UserRepository userrepository;
	
	@Autowired
	public UserService(UserRepository userrepository) {
		this.userrepository=userrepository;
	}
	
	public List<User> getusers(){
		return userrepository.findAll();
	}
	
	public User getUserById(int id) {
		return userrepository.findUserByUserId(id);
	}
	
	public User updateuser(User u)
	{
		return userrepository.save(u);
	}
	
	public User add(User u){
		User saveduser = this.userrepository.save(u);
		return saveduser; 
	}
	
	public boolean deleteuser(User u)
	{
		try
		{
		    userrepository.delete(u);
		    return true;
		}catch( Exception E)
		{
			return false;
		}
	}
	
	public List<User> finduser(int id)
	{
		return userrepository.finduserbyroleid(id);
	}

}
