package com.example.demo.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthRepository extends JpaRepository<Auth,Integer>{
	@Query(value="select * from auth a where auth_token=?1",nativeQuery=true)
	public Auth findByToken(String token);
	
	
}
