package com.cleverage.school.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * Represent a book of the school book.
 * 
 * @author David OLMETA
 */
@Entity
@Table(name = "page")
public class Book
{
	private int id;
	private int year;

	private Collection<Page> pages;

	/**
	 * Default Constructor.
	 */
	public Book()
	{
		// Default constructor for ORM System.
	}

	/**
	 * Custom constructor.
	 * 
	 * @param year
	 *           The year associated to the school book.
	 */
	public Book(final int year)
	{
		this.year = year;
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
	 * @return the year
	 */
	public int getYear()
	{
		return year;
	}

	/**
	 * @param year
	 *           the year to set
	 */
	public void setYear(final int year)
	{
		this.year = year;
	}

	/**
	 * @return the pages
	 */
	@OneToMany(mappedBy = "book")
	public Collection<Page> getPages()
	{
		return pages;
	}

	/**
	 * @param pages
	 *           the pages to set
	 */
	public void setPages(final Collection<Page> pages)
	{
		this.pages = pages;
	}

}
