package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] arg) {
		ApplicationContext ctx= new ClassPathXmlApplicationContext("mybean.xml");
		TestService t=(TestService) ctx.getBean("ts");
		/*
		  t.insertCustomer(new Customer(6, "Aanchal", "gmail", 1212L, "Bhilai"));
		  t.insertCustomer(new Customer(7, "Aanchal2", "gmail2", 12122L, "Bhilai2"));
		  t.insertCustomer(new Customer(5, "Aanchal3", "gmail3", 12123L, "Bhilai3"));
        */
		//t.deleteCustomer(5);
		//t.updateCustomer(new Customer(4, "Aanchal4", "gmail4", 12124L, "Bhilai4"));
		/*t.getAllCustomer().forEach(c->System.out.println("cid is :"+c.getCid()
		+ "\t cname is :"+ c.getCname()+"\t email is:"+ c.getEmail()+"\t phone number is :"
				+c.getPhone()+"\t city is :"+c.getCity()));
				*/
		Customer c=t.getoneCustomer(2);
		System.out.println("id="+c.getCid()+"    cname is="+c.getCname()+"  email is="+c.getEmail());
	
	} 
}
