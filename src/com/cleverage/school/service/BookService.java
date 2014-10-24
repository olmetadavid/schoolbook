package com.cleverage.school.service;

import java.util.Collection;

import com.cleverage.school.model.Book;


/**
 * Base interface for book service layer.
 *
 * @author David OLMETA
 */
public interface BookService
{
	/**
	 * Get a book by id.
	 *
	 * @param id
	 *           The unique id.
	 * @return The book object.
	 */
	public Book getBookForId(final int id);

	/**
	 * Get books.
	 *
	 * @return The books list.
	 */
	public Collection<Book> getBooks();


	/**
	 * Save a book for create or update.
	 *
	 * @param book
	 *           The book to create.
	 */
	public void saveBook(final Book book);
}
