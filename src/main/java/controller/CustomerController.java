package controller;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pojo.Customer;

@RestController
public class CustomerController {
	
	@RequestMapping("work1")
	public String work1(@RequestParam(name="cname") String cname,int age,
			@DateTimeFormat(pattern="yyyy-MM-dd") Date birth,
			@NumberFormat(pattern="$#,###.00") double price) {
		
		return "suc";
	}
	
	@RequestMapping("work2")
	public String work1(Customer c) {
		
		return "suc";
	}
	
	//mock
	@RequestMapping("work3")
	public String work3(HttpServletResponse resp) {
		resp.addCookie(new Cookie("psd", "123"));
		return "suc";
	}
	
	@RequestMapping("work4")
	public String work4(@CookieValue(name="psd") String psd) {
		
		return "suc";
	}
	//   /customers GET,customers/id GET,customers/cid/phones GET,/customers POST
	
	@RequestMapping("work5/{c_id}/w/{bid}")
	public String work5(@PathVariable(name="c_id") String cid,@PathVariable int bid) {
		
		return "suc";
	}
	
	@RequestMapping("work6/{cid}")
	public String work6(@PathVariable String cid,@MatrixVariable int offset) {
		System.out.println(cid+"\t"+offset);
		return "suc";
	}
}
