package controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pojo.Address;
import pojo.Customer;
@SessionAttributes(names= {"c","b"})
@Controller
public class CustomerController {
	@ModelAttribute(value="c")
	public Customer createCustomer() {
		Customer c=new Customer();
		c.setId(100);
		c.setCname("johnyu");
		return c;
	}
	
//	@ModelAttribute(value="c")
//	public void createCustomer(Model model) {
//		Customer c=new Customer();
//		c.setId(100);
//		c.setCname("johnyu");
//		model.addAttribute("c",c);
//	}
	
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
	public String work6(@MatrixVariable int offset,@MatrixVariable int st) {
		System.out.println("\t"+offset+"\t"+st);
		return "suc";
	}
	
	@RequestMapping(value="work7",method=RequestMethod.PUT)
	public String work7(String cname) {
		
		System.out.println(cname);
		return "suc";
	}
	@ResponseBody
	@RequestMapping(value="work8",method=RequestMethod.POST)
	public String work8(@RequestBody Customer c) {
		return "suc";
	}
	@RequestMapping(value="work9")
	public String work9(HttpServletRequest req,HttpSession sen,ServletContext container) {
//		req.setAttribute(name, o);
//		sen.setAttribute(name, value);
//		container.setAttribute(name, object);
		return "suc";
	}
	
	@RequestMapping(value="work10")
	public String work10(Customer c,Model model,ModelMap modeMap,Map<String, Object> map) {
		model.addAttribute("c",c);
		return "suc";
	}
	
	@RequestMapping(value="work11")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "suc";
	}
	
	@RequestMapping(value="work12")
	public String work12() {
		
		return "suc";
	}
	
	@RequestMapping(value="work13")
	public String work13(@ModelAttribute(name="c") Customer c) {
		
		return "suc";
	}
	
	@RequestMapping(value="work14")
	public String work14() {
		System.out.println("work14...");
		return "forward:/work15";
	}
	
	@RequestMapping(value="work15")
	public String work15(RedirectAttributes attrs) {
		System.out.println("work15....");
		attrs.addAttribute("q", 100);
		attrs.addAttribute("p",43);
		return "redirect:http://www.sohu.com";
	}
	
	@RequestMapping(value="work16")
	public void work16(HttpServletResponse resp,OutputStream out) throws Exception{
		resp.setContentType("image/png");
		InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("sprite1.png");
		byte[] buf=new byte[128];
		int len=0;
		while((len=in.read(buf))!=-1) {
			out.write(buf,0,len);
		}
		
		in.close();
	}
	
	
	@RequestMapping(value="work17")
	public void work17(HttpServletResponse resp,OutputStream out) throws Exception{
		resp.addHeader("Content-Disposition", "attachment;filename=abc.png");
		InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("sprite1.png");
//		byte[] buf=new byte[128];
//		int len=0;
//		while((len=in.read(buf))!=-1) {
//			out.write(buf,0,len);
	//		}
		byte[] buf=new byte[in.available()];
		in.read(buf);
		in.close();
		out.write(buf);
	}
	
	@ResponseBody
	@RequestMapping(value="work18")
	public byte[] work18(HttpServletResponse resp) throws Exception{
		resp.addHeader("Content-Disposition", "attachment;filename=abc.png");
		InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("sprite1.png");
//		byte[] buf=new byte[128];
//		int len=0;
//		while((len=in.read(buf))!=-1) {
//			out.write(buf,0,len);
	//		}
		byte[] buf=new byte[in.available()];
		in.read(buf);
		return buf;
	}
	@ResponseBody
	@RequestMapping(value="work19")
	public Customer work19(@ModelAttribute(name="c") Customer c) {
		Address addr=new Address();
		addr.setCity("sh");
		c.setAddr(addr);
		addr.setC(c);
		return c;
	}
	
	
	@RequestMapping(value="work20")
	public String work20() {
		System.out.println("work20....");
		return "suc";
	}
	
	@RequestMapping(value="work21")
	public String work21(String cname,MultipartFile header) {
		header.getSize();
		header.getOriginalFilename();
		header.getName();
//		byte[] buf=header.getBytes();
//		header.getInputStream();
		return "suc";
	}
	
	@RequestMapping(value="work22")
	public String work22() throws Exception{
		//int m=1/0;
		int[] ms=new int[2];
		ms[2]=100;
		return "suc";
	}
	
	@RequestMapping(value="work23")
	public String work23() throws SQLException{
		if(1==1) {
			throw new SQLException();
		}
		
		return "suc";
	}
	
	@ExceptionHandler(value=ArithmeticException.class)
	public String handlerAtrithmaticException() {
		return "error";
	}
	@ExceptionHandler(value=RuntimeException.class)
	public String handlerRuntimeException() {
		System.out.println("runtimee");
		return "error";
	}
	
	
	
}




