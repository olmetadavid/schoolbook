package com.cleverage.school.dao;

import java.util.Collection;

import com.cleverage.school.model.Page;


/**
 * Base interface for page database access.
 *
 * @author David OLMETA
 */
public interface PageDao
{
	/**
	 * Get a page by id.
	 *
	 * @param id
	 *           The unique id.
	 * @return The page object.
	 */
	public Page findPageById(final int id);

	/**
	 * Get pages.
	 *
	 * @return The pages list.
	 */
	public Collection<Page> findPages();


	/**
	 * Save a page for create or update.
	 *
	 * @param page
	 *           The page to create.
	 */
	public void savePage(final Page page);
}
