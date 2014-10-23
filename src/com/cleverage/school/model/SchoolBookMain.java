package com.cleverage.school.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cleverage.school.dao.HibernateUtil;


public class SchoolBookMain
{

	public static void main(final String[] args)
	{
		// A SessionFactory is set up once for an application
		final SessionFactory sessionFactory = HibernateUtil.createSessionFactory();

		// create a couple of students...
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new Student("David", "OLMETA"));
		session.getTransaction().commit();
		session.close();

		// now lets pull students from the database and list them
		session = sessionFactory.openSession();
		session.beginTransaction();
		final List<Student> result = session.createQuery("from Student").list();
		for (final Student student : result)
		{
			System.out.println("Student: " + student.getFirstname() + " " + student.getLastname());
		}
		session.getTransaction().commit();
		session.close();

	}
}
