package com.example.demo.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
	
	private RoleRepository rolerepository;
	
	@Autowired
	public RoleService(RoleRepository rolerepository) {
		this.rolerepository = rolerepository;
	}
	
	public Role addRole(Role R) {
		return rolerepository.save(R);
	}
	
	public Role updateRole(Role R)
	{
		return rolerepository.save(R);
	}
	
	public List<Role> getallRole()
	{
		return rolerepository.findAll();
	}

}
