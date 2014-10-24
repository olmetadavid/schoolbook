package com.cleverage.school.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * Represent a page of the school book.
 * 
 * @author David OLMETA
 */
@Entity
@Table(name = "page")
public class Page
{
	private int id;
	private Date date;

	private Collection<Schedule> schedules;
	private Book book;

	/**
	 * Default constructor.
	 */
	public Page()
	{
		// Default constructor for ORM System.
	}

	/**
	 * Custom constructor.
	 * 
	 * @param date
	 *           The date of the page.
	 */
	public Page(final Date date)
	{
		this.date = date;
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
	 * @return the date
	 */
	public Date getDate()
	{
		return date;
	}

	/**
	 * @param date
	 *           the date to set
	 */
	public void setDate(final Date date)
	{
		this.date = date;
	}

	/**
	 * @return the schedules
	 */
	@OneToMany(mappedBy = "page")
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

	/**
	 * @return the book
	 */
	@ManyToOne
	@JoinColumn(name = "book_id")
	public Book getBook()
	{
		return book;
	}

	/**
	 * @param book
	 *           the book to set
	 */
	public void setBook(final Book book)
	{
		this.book = book;
	}

}
