package com.example.demo.networkelement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NetworkElementService {
	private NetworkElementRepository networkelementrepo;
	@Autowired
	public NetworkElementService(NetworkElementRepository networkelementrepo) {
		this.networkelementrepo=networkelementrepo;
	}
	
	public NetworkElement add(NetworkElement N) {
		return networkelementrepo.save(N);
	}
	
	public List<NetworkElement> getall()
	{
		return networkelementrepo.findAll();
	}
	
	
	
}
