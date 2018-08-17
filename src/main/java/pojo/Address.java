package pojo;


import com.fasterxml.jackson.annotation.JsonBackReference;

public class Address {
	private String city;
	
	@JsonBackReference
	private Customer c;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Customer getC() {
		return c;
	}
	public void setC(Customer c) {
		this.c = c;
	}
	
}
