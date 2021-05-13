    package com.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;

public class TestService {
	@Autowired
	private JdbcTemplate template;
	
	//insert operation
	public void insertCustomer(Customer c) {
	String sql="insert into customer values (?,?,?,?,?)";
	Object args[]= {c.getCid(),c.getCname(),c.getEmail(),c.getPhone(),c.getCity()};
	template.update(sql, args);
	System.out.println("added customer");
	}
	//delete operation
	public void deleteCustomer(int cid) {
		String sql="delete from customer where cid=?";
		Object args[]= {cid};
		template.update(sql, args);
		System.out.println("Customer is Deleted");
		}
	//update operation
	public void updateCustomer(Customer c) {
		String sql="Update customer set cname=?,email=?,phone=?,city=? where cid=?";
		Object args[]= {c.getCname(), c.getEmail(),c.getPhone(), c.getCity(), c.getCid()};
		template.update(sql, args);
		System.out.println("Customer Updated");
		}
	//select all operation
	public List<Customer> getAllCustomer(){
		String sql="Select * from customer";
		List<Customer> customers=template.query(sql, new CustomerRowMapper());
		return customers;
	}
	//select one 
	public Customer getoneCustomer(int cid){
		String sql="Select * from customer where cid=?";
		Object argd[]= {cid};
		Customer c=template.queryForObject(sql,argd, new CustomerRowMapper());
		return c;
	}
	
}
