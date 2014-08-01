package com.user;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/createUser")
	public void createUser(HttpServletResponse response,
			@RequestParam("fname") String firstName,
			@RequestParam("lname") String lastName,
			@RequestParam("email") String email,
			@RequestParam("login") String login,
			@RequestParam("pwd") String pwd){
		
		try{
			PrintWriter out = response.getWriter();
			User user = new User(firstName,lastName,email,login,pwd);
			userDao.persist(user);
			
			out.print("User "+firstName+" Created!");
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	@RequestMapping("/userCount")
	public void getUserCount(HttpServletResponse response){
		try{
			PrintWriter out = response.getWriter();
			out.print(userDao.getUserCount());
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	@RequestMapping("/getAllUsers")
	public @ResponseBody List<User> getAllUsers(HttpServletResponse response){
		return userDao.getAllUsers();
	}
}
