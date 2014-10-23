package com.cleverage.school.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * Represent a student.
 * 
 * @author David OLMETA
 */
@Entity
@Table(name = "student")
public class Student
{
	private int id;
	private String firstname;
	private String lastname;

	private Collection<Schedule> schedules;

	/**
	 * Default empty constructor.
	 */
	public Student()
	{
		// Default constructor for ORM System.
	}

	/**
	 * Custom constructor.
	 * 
	 * @param firstname
	 *           The first name
	 * @param lastname
	 *           The last name
	 */
	public Student(final String firstname, final String lastname)
	{
		this.firstname = firstname;
		this.lastname = lastname;
	}

	/**
	 * Unique identifier for student.
	 * 
	 * @return The identifier.
	 */
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	public int getId()
	{
		return id;
	}

	/**
	 * Set unique identifier for student.
	 * 
	 * @param id
	 *           The identifier
	 */
	public void setId(final int id)
	{
		this.id = id;
	}

	/**
	 * Get first name of student.
	 * 
	 * @return The first name
	 */
	public String getFirstname()
	{
		return firstname;
	}

	/**
	 * Set the first name of student.
	 * 
	 * @param firstname
	 *           The first name
	 */
	public void setFirstname(final String firstname)
	{
		this.firstname = firstname;
	}

	/**
	 * Get the last name of student.
	 * 
	 * @return The last name.
	 */
	public String getLastname()
	{
		return lastname;
	}

	/**
	 * Set the last name of student.
	 * 
	 * @param lastname
	 *           The last name.
	 */
	public void setLastname(final String lastname)
	{
		this.lastname = lastname;
	}

	/**
	 * @return the schedules
	 */
	@ManyToMany(mappedBy = "students")
	public Collection<Schedule> getSchedules()
	{
		return schedules;
	}

	/**
	 * @param schedules
	 *           the schedules to set
	 */
	public void setSchedules(final Collection<Schedule> schedules)
	{
		this.schedules = schedules;
	}

}
