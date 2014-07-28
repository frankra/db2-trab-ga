package com.group;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GroupController {
	@Autowired
	private GroupDao groupDao;
	
	@RequestMapping("/createGroup")
	public void createGroup(HttpServletResponse response,
			@RequestParam("name") String groupName,
			@RequestParam("owner") String ownerName){
		try{
			PrintWriter out = response.getWriter();
			
			out.print("Group "+groupName+" Created!");
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	@RequestMapping("/groupCount")
	public void getGroupCount(HttpServletResponse response){
		try{
			PrintWriter out = response.getWriter();
			out.print(groupDao.getGroupCount());
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
