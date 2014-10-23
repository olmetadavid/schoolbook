package com.cleverage.school.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * Main hibernate class for hibernate use.
 * 
 * @author David OLMETA
 */
public class HibernateUtil
{
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	/**
	 * Create the session factory.
	 * 
	 * @return The session factory
	 */
	public static SessionFactory createSessionFactory()
	{
		final Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
}
