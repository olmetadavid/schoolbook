package com.cleverage.school.dao.impl;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cleverage.school.dao.HibernateUtil;
import com.cleverage.school.dao.PageDao;
import com.cleverage.school.model.Page;


/**
 * DAO for page.
 *
 * @author David OLMETA
 */
public class DefaultPageDao implements PageDao
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Page findPageById(final int id)
	{
		Page page = null;

		// Create session.
		Session session = null;
		try
		{
			// A SessionFactory is set up once for an application.
			final SessionFactory sessionFactory = HibernateUtil.createSessionFactory();

			// Create open session.
			session = sessionFactory.openSession();

			// Get Page.
			page = (Page) session.get(Page.class, id);
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

		return page;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<Page> findPages()
	{
		Collection<Page> pages = null;

		// Create session.
		Session session = null;
		try
		{
			// A SessionFactory is set up once for an application.
			final SessionFactory sessionFactory = HibernateUtil.createSessionFactory();

			// Create open session.
			session = sessionFactory.openSession();

			pages = session.createQuery("from Page").list();
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

		return pages;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void savePage(final Page page)
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
			session.save(page);
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
