package com.demo;

import com.model.Customer;
import com.service.CustomerService;
import com.to.CustomerTo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] arg) {
		//Customer c= new Customer(1, "Aanchall", "gmailiya", "bhilai",1111111111);
	ApplicationContext ctx=new ClassPathXmlApplicationContext("mybean.xml");
	CustomerService service=(CustomerService)ctx.getBean("cusservice");
	//add new custoomer
	    //service.addCustomer(c);
	
	//deletecustomer
	    //service.deleteCustomer(1);
	
	//update customer
	    //Customer c2=new Customer(2,"Aanchal Sahu", "gmailiyaa", "bhilaiansaa",1110005);
	    //c2.setCid(2);
     	//service.updateCustomer(c2);
	
	//getting All data
		/*service.getAllCustomer().forEach(data->{System.out.print(data.getCid());
		System.out.print(data.getEmail());
		System.out.print(data.getCname());
		System.out.println("");
		});*/
		
	//getting All data by to object
	    /*service.getAllCustomerTo().forEach(data->{
		System.out.print(data.getCid());
		System.out.print(data.getEmail());
		System.out.print(data.getCname());
		System.out.println("");*/
	
	//getting all data by to  object with hql
	/*service.getAllCustomerTo().forEach(data->{
		System.out.print(data.getCid()+" ");
		System.out.print(data.getEmail()+" ");
		System.out.print(data.getCname()+" ");
		System.out.print(data.getPhone()+" ");
		System.out.println("");})*/
		
		//getting all data by to  object with hql by city
	/*service.getAllCustomerToHqlbyCity("bhilai").forEach(data->{
			System.out.print(data.getCid()+" ");
			System.out.print(data.getEmail()+" ");
			System.out.print(data.getCname()+" ");
			System.out.print(data.getPhone()+" ");
			System.out.print(data.getCity()+" ");
			System.out.println("");});
		
	//getting all data by to  object with criteria by city
		      CustomerTo data= service.getAllCustomerbyEmailCriteria("gmailiyaa") ;
				System.out.print(data.getCid()+" ");
				System.out.print(data.getEmail()+" ");
				System.out.print(data.getCname()+" ");
				System.out.print(data.getPhone()+" ");
				System.out.print(data.getCity()+" ");*/
				
				//getting all data by to  object with criteria
			service.getAllCustomerToCriteria().forEach(data->{
						System.out.print(data.getCid()+" ");
						System.out.print(data.getEmail()+" ");
						System.out.print(data.getCname()+" ");
						System.out.print(data.getPhone()+" ");
						System.out.print(data.getCity()+" ");
						System.out.println("");});
			
	}
}
