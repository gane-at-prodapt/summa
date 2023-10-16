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
	private int[] userids = {1,2,3,4,5,6,7,8,9,10};
	@Bean("Auth")
	CommandLineRunner commandLineRunner(AuthRepository repo) {
		return args->{
			List<Auth> authList = new ArrayList<Auth>();
			for(int i=0;i<userids.length;i++) {
				Auth A = new Auth();
				User u = new User();
				u.setId(userids[i]);
				u.setEmail("user"+userids[i]+"@gmail.com");
				A.setUser(u);
				A.setAuthToken(Encryption.encrypt("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8"+"user"+userids[i]+"@gmail.com"));
				A.setModifiedOn(System.currentTimeMillis()/1000);
				authList.add(A);
			}
			repo.saveAll(authList);
		};
	}
}
