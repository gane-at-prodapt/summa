package com.example.demo.access;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AccessRepository extends JpaRepository<Access,Integer>{
	@Query(value="select * from access a where roleId=?1",nativeQuery=true)
	public List<Access> findByRole(int id);
}
