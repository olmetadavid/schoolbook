package com.cleverage.school.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * Represent a schedule of a day.
 * 
 * @author David OLMETA
 */
@Entity
@Table(name = "schedule")
public class Schedule
{
	private int id;
	private int startHour;
	private int endHour;
	private String content;

	private Collection<Student> students;

	/**
	 * Default Constructor.
	 */
	public Schedule()
	{
		// Default constructor for ORM System.
	}

	/**
	 * Custom constructor.
	 * 
	 * @param startHour
	 *           The start hour.
	 * @param endHour
	 *           The end hour.
	 * @param content
	 *           The text of the schedule.
	 */
	public Schedule(final int startHour, final int endHour, final String content)
	{
		this.startHour = startHour;
		this.endHour = endHour;
		this.content = content;
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	public int getId()
	{
		return id;
	}

	/**
	 * @param id
	 *           the id to set
	 */
	public void setId(final int id)
	{
		this.id = id;
	}

	/**
	 * @return the startHour
	 */
	public int getStartHour()
	{
		return startHour;
	}

	/**
	 * @param startHour
	 *           the startHour to set
	 */
	public void setStartHour(final int startHour)
	{
		this.startHour = startHour;
	}

	/**
	 * @return the endHour
	 */
	public int getEndHour()
	{
		return endHour;
	}

	/**
	 * @param endHour
	 *           the endHour to set
	 */
	public void setEndHour(final int endHour)
	{
		this.endHour = endHour;
	}

	/**
	 * @return the content
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * @param content
	 *           the content to set
	 */
	public void setContent(final String content)
	{
		this.content = content;
	}

	/**
	 * @return the students
	 */
	@ManyToMany(cascade =
	{ CascadeType.ALL })
	@JoinTable(name = "schedul2student", joinColumns =
	{ @JoinColumn(name = "student_id") }, inverseJoinColumns =
	{ @JoinColumn(name = "schedule_id") })
	public Collection<Student> getStudents()
	{
		return students;
	}

	/**
	 * @param students
	 *           the students to set
	 */
	public void setStudents(final Collection<Student> students)
	{
		this.students = students;
	}

}
