package com.cleverage.school.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SchoolBookMain
{

	public static void main(String[] args)
	{
		// A SessionFactory is set up once for an application
		SessionFactory sessionFactory = new Configuration()
                .configure() // configures settings from hibernate.cfg.xml
                .buildSessionFactory();
		
		
		
		// create a couple of events...
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				session.save( new Student("David", "OLMETA"));
				session.getTransaction().commit();
				session.close();

				// now lets pull events from the database and list them
				session = sessionFactory.openSession();
		        session.beginTransaction();
		        List<Student> result = session.createQuery( "from Event" ).list();
				for (Student student: result) {
					System.out.println("Student: " + student.getFirstname() + " " + student.getLastname());
				}
		        session.getTransaction().commit();
		        session.close();

	}

}
