package com.list;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ListController {
	@Autowired
	private ListDao listDao;
	
	
	@RequestMapping("/getListCount")
	public void getListCount(HttpServletResponse response){
		try{
			PrintWriter out = response.getWriter();
			out.print(listDao.getListCount());
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	@RequestMapping("/getList")
	public @ResponseBody com.list.List createUser(HttpServletResponse response,@RequestParam("listid") int id){
		return listDao.retrieve(id);
			
	}
	
	@RequestMapping("/getAllLists")
	public @ResponseBody java.util.List<com.list.List> getAllLists(HttpServletResponse response){
		return listDao.getLists();
	}
	
	
}
