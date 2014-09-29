package com.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	
	@RequestMapping(value="createUser",method = RequestMethod.POST)
	public @ResponseBody User createUser(@RequestBody User user){
		userDao.persist(user);
		
		return user;
	}
	
	@RequestMapping("/retrieveUser")
	public @ResponseBody User retrieveUser(@RequestParam("id") int id){
		return userDao.retrieve(id);
	}
	
	@RequestMapping("/updateUser")
	public @ResponseBody User updateUser(@RequestBody User user){
		return userDao.persist(user);
	}
	
	@RequestMapping("/deleteUser")
	public @ResponseBody User deleteUser(@RequestParam("id") int id){
		return userDao.delete(id);
	}
	
	
	@RequestMapping("/getUserList")
	public @ResponseBody List<User> getUserList(){
		return userDao.getAllUsers();
	};
	
	
}
