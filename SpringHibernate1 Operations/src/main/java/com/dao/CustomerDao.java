package com.dao;

import java.util.List;

import com.model.Customer;
import com.to.CustomerTo;

public interface CustomerDao { 
	public void addCustomer(Customer c);
	public void deleteCustomer(int cid);
	public void updateCustomer(Customer c);
	public List<Customer> getAllCustomer();
	public List<CustomerTo> getAllCustomerTo();
	public List<CustomerTo> getAllCustomerToHql();
	public List<CustomerTo> getAllCustomerToHqlbyCity(String city);
	public CustomerTo getAllCustomerbyEmailCriteria(String email);
	public List<CustomerTo> getAllCustomerToCriteria();
}
