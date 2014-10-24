package com.cleverage.school.dao;

import java.util.Collection;

import com.cleverage.school.model.Book;


/**
 * Base interface for book database access.
 *
 * @author David OLMETA
 */
public interface BookDao
{
	/**
	 * Get a book by id.
	 *
	 * @param id
	 *           The unique id.
	 * @return The book object.
	 */
	public Book findBookById(final int id);

	/**
	 * Get books.
	 *
	 * @return The books list.
	 */
	public Collection<Book> findBooks();


	/**
	 * Save a book for create or update.
	 *
	 * @param book
	 *           The book to create.
	 */
	public void saveBook(final Book book);
}
