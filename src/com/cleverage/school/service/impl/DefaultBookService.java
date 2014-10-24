package com.cleverage.school.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Required;

import com.cleverage.school.dao.BookDao;
import com.cleverage.school.model.Book;
import com.cleverage.school.service.BookService;


/**
 * Service for book.
 *
 * @author David OLMETA
 */
public class DefaultBookService implements BookService
{
	private BookDao bookDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Book getBookForId(final int id)
	{
		return getBookDao().findBookById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<Book> getBooks()
	{
		return getBookDao().findBooks();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveBook(final Book book)
	{
		getBookDao().saveBook(book);
	}

	/**
	 * @return the bookDao
	 */
	public BookDao getBookDao()
	{
		return bookDao;
	}

	/**
	 * @param bookDao
	 *           the bookDao to set
	 */
	@Required
	public void setBookDao(final BookDao bookDao)
	{
		this.bookDao = bookDao;
	}

}
