package controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//pojo
@RestController
@RequestMapping("me")//mount
public class CommonController{
	
	
	@RequestMapping(value="/x.a")
	public String login(Map<String, Object> map) {
		//call service....,get Model....
		map.put("uname", "John.Yu");
		System.out.println("login....");
		//view Name....
		
		return "suc";
	}
	
	@RequestMapping(value= {"/*.a"})
	public String regist() {
		//call service....,get Model....
		System.out.println("regist....");
		//view Name....
		
		return "suc";
	}
	
	@ResponseBody
	@RequestMapping(value="books",method=RequestMethod.GET)
	public String work1() {
		return "work1";
	}
	@ResponseBody
	@RequestMapping(value="books",method=RequestMethod.POST)
	public String work2() {
		return "work2";
	}
	
	@GetMapping("items")
	public String work3() {
		return "work3";
	}
	
	@PostMapping("items")
	public String work4() {
		return "work4";
	}
	
	@PostMapping(value="work5",headers="action=john")
	public String work5() {
		return "work5";
	}
	
	@PostMapping(value="work5",headers="action=tom")
	public String work51() {
		return "work51";
	}
	
	@PostMapping(value="work5",produces="application/json")
	public String work52() {
		return "work52";
	}
	
	@PostMapping(value="work6",params="id=1")
	public String work6() {
		return "work6";
	}
	@PostMapping(value="work6",params="id=2")
	public String work61() {
		return "work61";
	}
}
