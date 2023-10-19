package com.example.demo.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.example.demo.encryption.Encryption;
import com.example.demo.user.User;

@Configuration
public class AuthConfig {
	private String names[] = {"Stefan","Luffy","Erwin","Rebecca","Walter",
			"Klaus","Conrad","Kevin","Michael","Barney",
			"Marshall","Robin","Skyler","Jennie","Monica",
			"Dwight","Leonard","Sheldon","Howard","Roger"};
	
	@Bean("Auth")
	CommandLineRunner commandLineRunner(AuthRepository repo) {
		return args->{
			List<Auth> authList = new ArrayList<Auth>();
			for(int i=0;i<names.length;i++) {
				Auth A = new Auth();
				User u = new User();
				u.setId(i+1);
				//set email by name
				u.setName(names[i]);
				u.setEmail(names[i]+"11"+Integer.toString(i)+"@gmail.com");
				A.setUser(u);
				A.setAuthToken(Encryption.encrypt("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8"+names[i]+"11"+Integer.toString(i)+"@gmail.com"));
				A.setModifiedOn(System.currentTimeMillis()/1000);
				authList.add(A);
			}
			repo.saveAll(authList);
		};
	}
}
