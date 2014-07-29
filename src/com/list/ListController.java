package com.list;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ListController {
	@Autowired
	private ListDao listDao;
	
	
	@RequestMapping("/listCount")
	public void getGroupCount(HttpServletResponse response){
		try{
			PrintWriter out = response.getWriter();
			out.print(listDao.getListCount());
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	
}
