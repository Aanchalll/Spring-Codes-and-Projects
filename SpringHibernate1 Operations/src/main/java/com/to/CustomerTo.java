package com.to;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CustomerTo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int cid;
	public String cname;
	public String email;
	public String city;
	public int phone;
	
	public CustomerTo() {	}
	public CustomerTo(int cid, String cname, String email, String city, int phone) {
	
		this.cid = cid;
		this.cname = cname;
		this.email = email;
		this.city = city;
		this.phone = phone;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
}
