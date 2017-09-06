package com.controllers;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daos.GroupDao;
import com.entities.Group;

@Controller
public class GroupController {
	@Autowired
	private GroupDao groupDao;

	@RequestMapping("/retrieveGroup")
	public @ResponseBody Group retrieveGroup(@RequestParam("id") int id) {
		Group group = groupDao.retrieve(id);
		System.out.println(group.getGroupMembers());
		return group;
	}

	@RequestMapping("/createGroup")
	public void createGroup(HttpServletResponse response, @RequestParam("name") String groupName) {
		try {
			PrintWriter out = response.getWriter();
			Group group = new Group(groupName);
			groupDao.persist(group);
			out.print("Group " + groupName + " Created!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/groupCount")
	public void getGroupCount(HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			out.print(groupDao.getGroupCount());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/getAllGroups")
	public @ResponseBody List<Group> getAllGroups(HttpServletResponse response) {
		return groupDao.getAllGroups();
	}

}
