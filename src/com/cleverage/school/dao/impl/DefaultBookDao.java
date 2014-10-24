package com.cleverage.school.dao.impl;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cleverage.school.dao.BookDao;
import com.cleverage.school.dao.HibernateUtil;
import com.cleverage.school.model.Book;


/**
 * DAO for book.
 *
 * @author David OLMETA
 */
public class DefaultBookDao implements BookDao
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Book findBookById(final int id)
	{
		Book book = null;

		// Create session.
		Session session = null;
		try
		{
			// A SessionFactory is set up once for an application.
			final SessionFactory sessionFactory = HibernateUtil.createSessionFactory();

			// Create open session.
			session = sessionFactory.openSession();

			// Get Book.
			book = (Book) session.get(Book.class, id);
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

		return book;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<Book> findBooks()
	{
		Collection<Book> books = null;

		// Create session.
		Session session = null;
		try
		{
			// A SessionFactory is set up once for an application.
			final SessionFactory sessionFactory = HibernateUtil.createSessionFactory();

			// Create open session.
			session = sessionFactory.openSession();

			books = session.createQuery("from Book").list();
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

		return books;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveBook(final Book book)
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
			session.save(book);
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
