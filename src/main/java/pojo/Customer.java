package pojo;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class Customer {
	
	private Integer id;
	private String cname;
	private int age;
	@JsonManagedReference
	private Address addr;
	
	
	public Customer() {
		System.out.println("customer constructing....");
	}
	
	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
