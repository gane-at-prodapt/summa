package com.example.demo.access;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessService {
	
	private AccessRepository accessrepository;
	@Autowired
	public AccessService(AccessRepository accessrepository) {
		this.accessrepository=accessrepository;
	}
	
	public Access add(Access A) {
		return accessrepository.save(A);
	}
	
	public List<Access> addBulk(List<Access> A){
		return accessrepository.saveAll(A);
	}
	public List<Access> getByRole(int id){
		return accessrepository.findByRole(id);
	}
	public boolean delete(Access A) {
		try {
			accessrepository.delete(A);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
}
