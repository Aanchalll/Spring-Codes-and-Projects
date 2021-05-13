package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.model.Customer;
import com.mysql.jdbc.util.ResultSetUtil;
import com.to.CustomerTo;

@Transactional
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	HibernateTemplate template;

	@Override
	public void addCustomer(Customer c) {
		template.save(c);
		System.out.println("data saved");
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
	public void deleteCustomer(int cid) {
    Customer customer=	template.load(Customer.class, cid);
	template.delete(customer,LockMode.NONE);
	System.out.println("Deleteddd      ");
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
	public void updateCustomer(Customer c) {
		template.update(c);
		System.out.println("data updated");
	}
	@Override
	//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
	public List<Customer> getAllCustomer() {
		List<Customer> list=template.loadAll(Customer.class);
		return list;
	}

	@Override
	public List<CustomerTo> getAllCustomerTo() {
		List<Customer> list=template.loadAll(Customer.class);
		List<CustomerTo> result=new ArrayList<CustomerTo>();
		for(Customer c:list)
		{
			CustomerTo cto=new CustomerTo(c.getCid(), c.getCname(), c.getEmail(), c.getCity(), c.getPhone());
			result.add(cto);
		}
		return result;
	}

	@Override
	public List<CustomerTo> getAllCustomerToHql() {
		List<CustomerTo> result=new ArrayList<CustomerTo>();
		String hql="from Customer";
		List<Customer> cust=(List<Customer>) template.find(hql);
		for(Customer c: cust) {
			List<CustomerTo> cto= (List<CustomerTo>) new CustomerTo(c.getCid(), c.getCname(), c.getEmail(), c.getCity(), c.getPhone());
		result.add((CustomerTo) cto);
		}
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
	public List<CustomerTo> getAllCustomerToHqlbyCity(String city) {
		List<CustomerTo> result=new ArrayList<CustomerTo>();
		String hql="from Customer where city=? ";
		List<Customer> cust=(List<Customer>) template.find(hql,city);
		for(Customer c: cust) {
			CustomerTo cto=new CustomerTo(c.getCid(), c.getCname(), c.getEmail(), c.getCity(), c.getPhone());
		result.add((CustomerTo) cto);
		}
		return result;
	}

	@Override
	public CustomerTo getAllCustomerbyEmailCriteria(String email) {
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Customer.class);
		detachedCriteria.add(Expression.eq("email", email));
		List<Customer> cust=(List<Customer>) template.findByCriteria(detachedCriteria);
		Customer c=cust.get(0);
		CustomerTo cto= new CustomerTo(c.getCid(), c.getCname(), c.getEmail(), c.getCity(), c.getPhone());
		return cto;
	}

	@Override
	public List<CustomerTo> getAllCustomerToCriteria() {
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Customer.class);
		List<Customer> cust=(List<Customer>) template.findByCriteria(detachedCriteria);
		List<CustomerTo> result=new ArrayList<CustomerTo>();
		for(Customer c: cust) {
		CustomerTo cto= new CustomerTo(c.getCid(), c.getCname(), c.getEmail(), c.getCity(), c.getPhone());
		result.add(cto);
		}
		return result;

	}
}
