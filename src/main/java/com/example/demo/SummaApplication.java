package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.access.AccessConfig;
import com.example.demo.assignmentgroup.AssignmentGroup;
import com.example.demo.assignmentgroup.AssignmentGroupConfig;
import com.example.demo.auth.AuthConfig;
import com.example.demo.issue.Issue;
import com.example.demo.issue.IssueConfig;
import com.example.demo.module.ModuleConfig;
import com.example.demo.networkelement.NetworkElementConfig;
import com.example.demo.role.RoleConfig;
import com.example.demo.user.UserConfig;

@SpringBootApplication
public class SummaApplication {

	public static void main(String[] args) {
		SpringApplication.run(
				new Class[] {
						SummaApplication.class,
						RoleConfig.class,
						ModuleConfig.class,
						AccessConfig.class,
						UserConfig.class,
						AuthConfig.class,
						NetworkElementConfig.class,
						IssueConfig.class,
						AssignmentGroupConfig.class,
						},
				args);
	}

}
