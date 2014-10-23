package com.cleverage.school.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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

	/**
	 * Default empty constructor.
	 */
	public Student()
	{
		// Constructor used by hibernate.
	}

	/**
	 * Custom constructor.
	 */
	public Student(final String firstname, final String lastname)
	{
		this.firstname = firstname;
		this.lastname = lastname;
	}

	@Id
	@GeneratedValue(generator="increment")
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public String getLastname()
	{
		return lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}
}
