package controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//pojo
@Controller
public class CommonController{
	
	
	@RequestMapping(value="/login")
	public String login(Map<String, Object> map) {
		//call service....,get Model....
		map.put("uname", "John.Yu");
		System.out.println("login....");
		//view Name....
		
		return "suc";
	}
}
