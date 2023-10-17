package com.example.demo.groupmembers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface GroupMembersRepository extends JpaRepository<GroupMembers, Integer>{
	@Query(value="select * from group_members where member_id=?1",nativeQuery=true)
	public List<GroupMembers> findGroupsByMember(int id);
	
	@Query(value="select * from group_members where group_id=?1",nativeQuery=true)
	public List<GroupMembers> findMembersByGroup(int id);
	
	@Query(value="select * from group_members where group_id=?1 and member_id=?2",nativeQuery=true)
	public GroupMembers find(int groupId,int memberId);
	
}
