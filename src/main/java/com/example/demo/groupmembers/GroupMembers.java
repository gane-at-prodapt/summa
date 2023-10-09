package com.example.demo.groupmembers;

import com.example.demo.assignmentgroup.AssignmentGroup;
import com.example.demo.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class GroupMembers {
	
	@Id
	@SequenceGenerator(
			name="groupmember_sequence",
			sequenceName="groupmember_sequence",
			allocationSize=1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "groupmember_sequence"
			
	)
	private int id;
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
    @JoinColumn(name = "groupId", referencedColumnName = "id",nullable=false)
	private AssignmentGroup assignmentGroup;
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
    @JoinColumn(name = "memberId", referencedColumnName = "id",nullable=false)
	private User GroupMember;
	@Column(nullable=false)
	private long modifiedOn;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AssignmentGroup getGroup() {
		return assignmentGroup;
	}
	public void setGroup(AssignmentGroup assignmentGroup) {
		this.assignmentGroup = assignmentGroup;
	}
	public User getGroupMember() {
		return GroupMember;
	}
	public void setGroupMember(User groupMember) {
		GroupMember = groupMember;
	}
	public long getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(long modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	

}
