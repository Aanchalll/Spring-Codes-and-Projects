package com.demo;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class TestMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("mybean.xml");
        TestService ts=(TestService)ctx.getBean("ts");
        //ts.insertCustomer(new Customer(5,"pawan","pawan@gmail.com",9964012419L,"jajpur"));
        //  ts.deleteCustomer(1);
       // ts.updateCustomer(new Customer(1,"bikash1","bdash1@gmail.com",9964012412L,"ctc"));
       // ts.getAllCustomer().forEach(c ->System.out.println(c.getCid()+"\t"+c.getCity()+"\t"+c.getCname()));
       // Customer c=ts.getCustomerByCid(1);
       // System.out.println(c.getCid()+"\t"+c.getCity()+"\t"+c.getCname());
        ts.getCustomerByCity("jajpur").forEach(c ->System.out.println(c.getCid()+"\t"+c.getCity()+"\t"+c.getCname()));
        
	}

}

