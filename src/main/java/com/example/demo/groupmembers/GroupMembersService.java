package com.example.demo.groupmembers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupMembersService {
	private GroupMembersRepository groupmembersrepo;
	@Autowired
	public GroupMembersService(GroupMembersRepository groupmembersrepo) {
		this.groupmembersrepo=groupmembersrepo;
	}
	
	public GroupMembers add(GroupMembers G) {
		return groupmembersrepo.save(G);
	}
	
	public List<GroupMembers>getGroupsByMember(int memberId) {
		return groupmembersrepo.findGroupsByMember(memberId);
	}
	public List<GroupMembers>getMembersByGroup(int memberId) {
		return groupmembersrepo.findMembersByGroup(memberId);
	}
	public boolean removeMemberFromGroup(GroupMembers G) {
		try {
			GroupMembers found = groupmembersrepo.find(G.getGroup().getId(), G.getGroupMember().getId());
			groupmembersrepo.delete(found);
			return true;
		}catch(Exception E) {
			return false;
		}
	}
	
}
