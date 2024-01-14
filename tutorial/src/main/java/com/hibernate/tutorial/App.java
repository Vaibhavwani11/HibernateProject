package com.hibernate.tutorial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	//Thread safe object, SessionFactory is interface
    	//will throw an error if properties are not correctly configured in xml file & if file is not placed at correct location
    	//need to add path if config file is not placed in src/main/java
    	Configuration cfg = new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	
    	System.out.println("Creating tables on buildSessionFactory method call: ");
    	SessionFactory factory = cfg.buildSessionFactory();
    	
//    	SessionFactory factory = new Configuration().configure().buildSessionFactory();
    	System.out.println(factory);
    	
    	//Creating student
    	Student st= new Student();
    	st.setId(101);
    	st.setName("Vaibhav");
    	st.setCity("Pune");
    	System.out.println(st);
    	
    	
    	//CREATING ADDRESS Column ROW 1
    	Address ad = new Address();
    	ad.setStreet("Downtown street");
    	ad.setOpen(true);
    	ad.setCity("Pune, India");
    	ad.setAddedDate(new Date());
    	ad.setX(1234); //won't be saved in DB as x is ignored
    	
    	//ROW 2
    	Address ad2 = new Address();
    	ad2.setStreet("MG Road");
    	ad2.setOpen(false);
    	ad2.setCity("Mumbai, Maharashtra");
    	ad2.setAddedDate(new Date());
    	ad2.setX(12345);
    	
    	//Reading image
//    	FileInputStream fis = new FileInputStream("C:\\Users\\Vaibhav\\Pictures");
    	//byte[]  data = new byte[fis.available()];
//    	fis.read(data);
    	
//    	ad.setImage(data);
    	
    	//now we need to save this in our DB -> OPEN SESSION
    	Session session = factory.openSession();
    	
    	//start transaction
    	Transaction tx = session.beginTransaction();
    	
    	//save data object
    	System.out.println("Insert Queries on persist method call:");
    	session.persist(ad); //save is deprecated
    	session.persist(ad2);

    	System.out.println("Delete Query: ");
    	session.remove(ad);
    	//commit 
    	session.getTransaction().commit(); //or  tx.commit();
    	
    	session.close();
    	
    	System.out.println("Transaction completed Successfully!!");
    }

}