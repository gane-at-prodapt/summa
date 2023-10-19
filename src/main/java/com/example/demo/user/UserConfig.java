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

	private String names[] = {"Stefan","Luffy","Erwin","Rebecca","Walter",
	"Klaus","Conrad","Kevin","Michael","Barney",
	"Marshall","Robin","Skyler","Jennie","Monica",
	"Dwight","Leonard","Sheldon","Howard","Roger"};
	private int[] roles = {1,2,3,4,5,
			2,3,4,2,
			3,4,2,3,
			4,2,3,4,2,3,4}; 

	@Bean("user")
	CommandLineRunner commandLineRunner(UserRepository repo) {
		return args ->{
			List<User> users = new ArrayList<User>();
			for(int i=0;i<names.length;i++) {
				User u = new User();
				u.setName(names[i]);
				Role R = new Role();
				R.setId(roles[i]);
				u.setRole(R);
				u.setEmail(names[i]+"11"+Integer.toString(i)+"@gmail.com");
				u.setCreatedOn(System.currentTimeMillis()/1000);
				users.add(u);
			}
			repo.saveAll(users);
		};
	}
}
