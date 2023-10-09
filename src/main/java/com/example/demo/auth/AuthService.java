package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	
	private final AuthRepository authrepository;
	
	@Autowired
	public AuthService(AuthRepository authrepository) {
		this.authrepository = authrepository;
	}
	
	public Auth login(String token) {
		return authrepository.findByToken(token);
	}

	public Auth add(Auth a) {
		// TODO Auto-generated method stub
		return authrepository.save(a);
	}

}
