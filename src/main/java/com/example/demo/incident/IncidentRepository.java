package com.example.demo.incident;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IncidentRepository extends JpaRepository<Incident,Integer>{
	@Query(value="select * from incident where assignmentGroup_Id=?1",nativeQuery=true)
	public List<Incident> findIncidentsbyGroup(int id);
	
	@Query(value="select * from incident where assignedTo_Id=?1",nativeQuery=true)
	public List<Incident> findIncidentsbyMember(int id);
	
	@Query(value="select * from incident where issue_Id=?1",nativeQuery=true)
	public List<Incident> findIncidentsbyIssue(int id);
	
	@Query(value="select * from incident where ?1",nativeQuery=true)
	public List<Incident> findIncidentsbyMemberGroups(String query);
	
	
}
