package com.cleverage.school.dao;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cleverage.school.model.Student;


/**
 * DAO for student.
 * 
 * @author David OLMETA
 */
public class DefaultStudentDao implements StudentDao
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Student getStudent(final int id)
	{
		Student student = null;

		// Create session.
		Session session = null;
		try
		{
			// A SessionFactory is set up once for an application.
			final SessionFactory sessionFactory = HibernateUtil.createSessionFactory();

			// Create open session.
			session = sessionFactory.openSession();

			// Get Student.
			student = (Student) session.get(Student.class, id);
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				session.close();
			}
			catch (final Exception e)
			{
				e.printStackTrace();
			}
		}

		return student;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<Student> getStudents()
	{
		Collection<Student> students = null;

		// Create session.
		Session session = null;
		try
		{
			// A SessionFactory is set up once for an application.
			final SessionFactory sessionFactory = HibernateUtil.createSessionFactory();

			// Create open session.
			session = sessionFactory.openSession();

			students = session.createQuery("from Student").list();
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				session.close();
			}
			catch (final Exception e)
			{
				e.printStackTrace();
			}
		}

		return students;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveStudent(final Student student)
	{
		// Create session.
		Session session = null;

		try
		{
			// A SessionFactory is set up once for an application.
			final SessionFactory sessionFactory = HibernateUtil.createSessionFactory();

			// Create open session.
			session = sessionFactory.openSession();

			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				session.close();
			}
			catch (final Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
