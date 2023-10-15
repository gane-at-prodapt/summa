package com.example.demo.groupmembers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.assignmentgroup.AssignmentGroup;
import com.example.demo.user.User;

@Configuration
public class GroupMembersConfig {
	
	private int[] members1 = {2,3,4};
	private int[] members2 = {7,8,9};
	private int[] groups1 = {7,9,11};
	private int[] groups2 = {8,10,12};
	
	
	@Bean("GroupMembers")
	CommandLineRunner commandLineRunner(GroupMembersRepository repo) {
		return args -> {
			List<GroupMembers> groupmembers = new ArrayList<GroupMembers>();
			for(int i=0;i<groups1.length;i++) {
				for(int j=0;j<members1.length;j++) {
					GroupMembers G = new GroupMembers();
					AssignmentGroup A = new AssignmentGroup();
					A.setId(groups1[i]);
					User U = new User();
					U.setId(members1[j]);
					G.setGroup(A);
					G.setGroupMember(U);
					G.setModifiedOn(System.currentTimeMillis()/1000);
					groupmembers.add(G);
				}
			}
			for(int i=0;i<groups2.length;i++) {
				for(int j=0;j<members2.length;j++) {
					GroupMembers G = new GroupMembers();
					AssignmentGroup A = new AssignmentGroup();
					A.setId(groups2[i]);
					User U = new User();
					U.setId(members2[j]);
					G.setGroup(A);
					G.setGroupMember(U);
					G.setModifiedOn(System.currentTimeMillis()/1000);
					groupmembers.add(G);
				}
			}
			repo.saveAll(groupmembers);
		};
	}
}
