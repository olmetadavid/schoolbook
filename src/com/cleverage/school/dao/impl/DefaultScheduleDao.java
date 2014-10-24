package com.cleverage.school.dao.impl;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cleverage.school.dao.HibernateUtil;
import com.cleverage.school.dao.ScheduleDao;
import com.cleverage.school.model.Schedule;


/**
 * DAO for schedule.
 *
 * @author David OLMETA
 */
public class DefaultScheduleDao implements ScheduleDao
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Schedule findScheduleById(final int id)
	{
		Schedule schedule = null;

		// Create session.
		Session session = null;
		try
		{
			// A SessionFactory is set up once for an application.
			final SessionFactory sessionFactory = HibernateUtil.createSessionFactory();

			// Create open session.
			session = sessionFactory.openSession();

			// Get Page.
			schedule = (Schedule) session.get(Schedule.class, id);
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

		return schedule;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<Schedule> findSchedules()
	{
		Collection<Schedule> schedules = null;

		// Create session.
		Session session = null;
		try
		{
			// A SessionFactory is set up once for an application.
			final SessionFactory sessionFactory = HibernateUtil.createSessionFactory();

			// Create open session.
			session = sessionFactory.openSession();

			schedules = session.createQuery("from Schedule").list();
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

		return schedules;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveSchedule(final Schedule schedule)
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
			session.save(schedule);
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
