package com.example.demo.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.example.demo.role.Role;

@Configuration
public class UserConfig {

	private String names[] = {"user1","user2","user3","user4","user5","user6","user7","user8","user9","user10"};
	private int[] roles = {1,2,3,4,5,1,2,3,4,5}; 

	@Bean("user")
	CommandLineRunner commandLineRunner(UserRepository repo) {
		return args ->{
			List<User> users = new ArrayList<User>();
			for(int i=0;i<10;i++) {
				User u = new User();
				u.setName(names[i]);
				Role R = new Role();
				R.setId(roles[i]);
				u.setRole(R);
				u.setEmail(names[i]+"@gmail.com");
				u.setCreatedOn(System.currentTimeMillis()/1000);
				users.add(u);
			}
			repo.saveAll(users);
		};
	}
}
