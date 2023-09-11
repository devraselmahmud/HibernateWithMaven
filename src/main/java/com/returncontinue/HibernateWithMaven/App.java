package com.returncontinue.HibernateWithMaven;

import java.io.FileInputStream;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) throws IOException {

		System.out.println("Project Started Successfully!");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		// creating student
		Student st = new Student();
		st.setId(101);
		st.setName("Rasel Mahmud");
		
		//taking images
		FileInputStream fis = new FileInputStream("src/main/java/flower.jpg");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		st.setImage(data);
		
		st.setCity("Dhaka");
		System.out.println(st);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(st);
		tx.commit();
		session.close();
		System.out.println("Done..");
	}
}
