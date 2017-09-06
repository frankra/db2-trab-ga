package com.controllers;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daos.MemberDao;

@Controller
public class MemberController {

	@Autowired
	private MemberDao memberDao;

	@RequestMapping("/getMemberByUserID")
	public void createUser(HttpServletResponse response, @RequestParam("userID") int userID) {

		try {
			PrintWriter out = response.getWriter();
			out.print(memberDao.getMemberByUserID(userID));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/memberCount")
	public void getUserCount(HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			out.print(memberDao.getMemberCount());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
