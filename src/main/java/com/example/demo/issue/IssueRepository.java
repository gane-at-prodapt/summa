package com.example.demo.issue;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer>{
	@Query(value="select * from issue where network_family=?1",nativeQuery=true)
	public List<Issue> findIssuesByNetworkDevice(String network_family);
}
