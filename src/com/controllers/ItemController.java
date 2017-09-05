package com.controllers;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daos.ItemDao;


@Controller
public class ItemController {
  @Autowired
  private ItemDao itemDao;
  
  
  @RequestMapping("/itemCount")
  public void getGroupCount(HttpServletResponse response){
    try{
      PrintWriter out = response.getWriter();
      out.print(itemDao.getItemCount());
    }catch(Exception e){
      e.printStackTrace();
    }    
  }
  
  
}
