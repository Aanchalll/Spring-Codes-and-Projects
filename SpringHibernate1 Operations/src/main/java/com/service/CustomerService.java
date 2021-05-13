package com.service;

import java.util.List;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.model.Customer;
import com.to.CustomerTo;

public class CustomerService {
	@Autowired
	CustomerDao dao;
public void addCustomer(Customer c) {
	dao.addCustomer(c);
}
public void deleteCustomer(int cid) {
dao.deleteCustomer(cid);
}
public void updateCustomer(Customer c) {
dao.updateCustomer(c);
}
public List<Customer> getAllCustomer() {
	return dao.getAllCustomer();	
}
public List<CustomerTo> getAllCustomerTo(){
	return dao.getAllCustomerTo();
}
public List<CustomerTo> getAllCustomerToHqlbyCity(String city){
	return dao.getAllCustomerToHqlbyCity(city);
}
public CustomerTo getAllCustomerbyEmailCriteria(String email) {
return dao.getAllCustomerbyEmailCriteria(email);
}
public List<CustomerTo> getAllCustomerToCriteria(){
	return dao.getAllCustomerToCriteria();
}
}

