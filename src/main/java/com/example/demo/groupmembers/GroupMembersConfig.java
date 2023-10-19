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
	private int[] groups1 = {17,18};
	private int[] members2 = {5,6,7};
	private int[] groups2 = {25,26};
	private int[] members3 = {8,9,10};
	private int[] groups3 = {39,40};
	private int[] members4 = {11,12,13};
	private int[] groups4 = {61,62};
	private int[] members5 = {14,15,16};
	private int[] groups5 = {51,52};
	private int[] members6 = {17,18,19,20};
	private int[] groups6 = {3,4};
	
	private int[] members7 = {5,12,4,19};
	private int[] groups7 = {3,4,17,18,25,16,39,40,61,62,51,52};
	
	
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
			
			for(int i=0;i<groups3.length;i++) {
				for(int j=0;j<members3.length;j++) {
					GroupMembers G = new GroupMembers();
					AssignmentGroup A = new AssignmentGroup();
					A.setId(groups3[i]);
					User U = new User();
					U.setId(members3[j]);
					G.setGroup(A);
					G.setGroupMember(U);
					G.setModifiedOn(System.currentTimeMillis()/1000);
					groupmembers.add(G);
				}
			}
			
			for(int i=0;i<groups4.length;i++) {
				for(int j=0;j<members4.length;j++) {
					GroupMembers G = new GroupMembers();
					AssignmentGroup A = new AssignmentGroup();
					A.setId(groups4[i]);
					User U = new User();
					U.setId(members4[j]);
					G.setGroup(A);
					G.setGroupMember(U);
					G.setModifiedOn(System.currentTimeMillis()/1000);
					groupmembers.add(G);
				}
			}
			
			for(int i=0;i<groups5.length;i++) {
				for(int j=0;j<members5.length;j++) {
					GroupMembers G = new GroupMembers();
					AssignmentGroup A = new AssignmentGroup();
					A.setId(groups5[i]);
					User U = new User();
					U.setId(members5[j]);
					G.setGroup(A);
					G.setGroupMember(U);
					G.setModifiedOn(System.currentTimeMillis()/1000);
					groupmembers.add(G);
				}
			}
			
			for(int i=0;i<groups6.length;i++) {
				for(int j=0;j<members6.length;j++) {
					GroupMembers G = new GroupMembers();
					AssignmentGroup A = new AssignmentGroup();
					A.setId(groups6[i]);
					User U = new User();
					U.setId(members6[j]);
					G.setGroup(A);
					G.setGroupMember(U);
					G.setModifiedOn(System.currentTimeMillis()/1000);
					groupmembers.add(G);
				}
			}
			
			for(int i=1;i<=62;i++) {
				for(int j=0;j<members7.length;j++) {
					boolean flag=true;
					for(int k=0;k<groups7.length;k++) {
						if(groups7[k]==i) {
							flag=false;
						}
					}
					if(flag) {
						GroupMembers G = new GroupMembers();
						AssignmentGroup A = new AssignmentGroup();
						A.setId(i);
						User U = new User();
						U.setId(members7[j]);
						G.setGroup(A);
						G.setGroupMember(U);
						G.setModifiedOn(System.currentTimeMillis()/1000);
						groupmembers.add(G);
					}
				}
			}
			repo.saveAll(groupmembers);
		};
	}
}
