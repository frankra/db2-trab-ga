package tests;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RESTServiceTest {

  @RequestMapping(value = "/RESTTest", method = RequestMethod.POST)
  public void RESTPrintTest(HttpServletResponse response,
      @RequestParam(required=false) String str1,
      @RequestParam(required=false) String str2,
      @RequestParam(required=false) String str3){
    
    System.out.println(str1);
    System.out.println(str2);
    System.out.println(str3);
    
    try {
      PrintWriter out = response.getWriter();
      
      out.print("ok");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  };
  
}
