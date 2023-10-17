package com.example.demo.networkelement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface NetworkElementRepository extends JpaRepository<NetworkElement, Integer>{
	
	@Query(value="select * from network_element where device_family=?1",nativeQuery=true)
	public List<NetworkElement> findNetworkElementsByFamily(String network_family);

}
