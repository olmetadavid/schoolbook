package com.cleverage.school.service;

import java.util.Collection;

import com.cleverage.school.model.Page;


/**
 * Base interface for page service layer.
 *
 * @author David OLMETA
 */
public interface PageService
{
	/**
	 * Get a page by id.
	 *
	 * @param id
	 *           The unique id.
	 * @return The page object.
	 */
	public Page getPageForId(final int id);

	/**
	 * Get pages.
	 *
	 * @return The pages list.
	 */
	public Collection<Page> getPages();


	/**
	 * Save a page for create or update.
	 *
	 * @param page
	 *           The page to create.
	 */
	public void savePage(final Page page);
}
