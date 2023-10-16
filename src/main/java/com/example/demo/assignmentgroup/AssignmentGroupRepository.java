package com.example.demo.assignmentgroup;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentGroupRepository extends JpaRepository<AssignmentGroup, Integer>{

	@Query(value="select * from assignment_group a where issue_id=?1",nativeQuery=true)
	public List<AssignmentGroup> findByIssue(int issueId);
}
