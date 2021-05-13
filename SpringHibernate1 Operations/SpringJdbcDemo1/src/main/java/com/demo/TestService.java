package com.demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
public class TestService {
	@Autowired
	private JdbcTemplate template;	
	
	public void insertCustomer(Customer c) {
		String sql="insert into Customers values(?,?,?,?,?)";
		Object args[]= {c.getCid(),c.getCname(),c.getEmail(),c.getPhone(),c.getCity()};
		template.update(sql, args);
		System.out.println("customer is added");
	}
	public void deleteCustomer(int cid) {
		String sql="delete from Customers where cid=?";
		Object args[]= {cid};
		template.update(sql, args);
		System.out.println("customer is deleted");
	}
	public void updateCustomer(Customer c) {
		String sql="update Customers set cname=?,email=?,city=?,phone=? where cid=?";
		Object args[]= {c.getCname(),c.getEmail(),c.getCity(),c.getPhone(),c.getCid()};
		template.update(sql, args);
		System.out.println("customer is updated");
	}
	public List<Customer> getAllCustomer(){
		String sql="select * from customers";
		List<Customer> customers=template.query(sql, new CustomerRowMapper());
		return customers;
	}
	public Customer getCustomerByCid(int cid) {
		String sql="select * from customers where cid=?";
		Object args[]= {cid};
		Customer c=template.queryForObject(sql, args, new CustomerRowMapper());
		return c;
	}
	
	public List<Customer> getCustomerByCity(String city) {
		String sql="select * from customers where city=?";
		Object args[]= {city};
		List<Customer> customers=template.query(sql, args, new CustomerRowMapper());
		return customers;
	}

}
