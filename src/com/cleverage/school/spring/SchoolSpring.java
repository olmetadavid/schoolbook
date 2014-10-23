package com.cleverage.school.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Allows access to spring configuration.
 * 
 * @author David OLMETA
 */
public class SchoolSpring
{
	// Singleton intance.
	private static SchoolSpring instance;

	private final String filename = "school-spring.xml";
	private final ClassPathXmlApplicationContext context;

	/**
	 * Private constructor.
	 */
	private SchoolSpring()
	{
		// Create a context from config file.
		context = new ClassPathXmlApplicationContext(filename);
	}

	/**
	 * Singleton method allows to get the only instance.
	 * 
	 * @return The only instance.
	 */
	public static synchronized SchoolSpring getInstance()
	{
		if (instance == null)
		{
			instance = new SchoolSpring();
		}
		return instance;
	}

	/**
	 * Get bean from spring config.
	 * 
	 * @param beanName
	 *           The bean name.
	 * 
	 * @return The bean.
	 */
	public Object getBean(final String beanName)
	{
		return context.getBean(beanName);
	}
}
