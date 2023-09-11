package com.returncontinue.HibernateWithMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		System.out.println("Project Started Successfully!");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		// creating student
		Student st = new Student();
		st.setId(101);
		st.setName("Rasel Mahmud");
		st.setCity("Dhaka");
		System.out.println(st);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(st);
		tx.commit();
		session.close();
	}
}
