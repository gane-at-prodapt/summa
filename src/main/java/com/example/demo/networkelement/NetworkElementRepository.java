package com.example.demo.networkelement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetworkElementRepository extends JpaRepository<NetworkElement, Integer>{

}
