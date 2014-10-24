package com.cleverage.school.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Required;

import com.cleverage.school.dao.PageDao;
import com.cleverage.school.model.Page;
import com.cleverage.school.service.PageService;


/**
 * Service for page.
 *
 * @author David OLMETA
 */
public class DefaultPageService implements PageService
{
	private PageDao pageDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Page getPageForId(final int id)
	{
		return getPageDao().findPageById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<Page> getPages()
	{
		return getPageDao().findPages();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void savePage(final Page page)
	{
		getPageDao().savePage(page);
	}

	/**
	 * @return the pageDao
	 */
	public PageDao getPageDao()
	{
		return pageDao;
	}

	/**
	 * @param pageDao
	 *           the pageDao to set
	 */
	@Required
	public void setPageDao(final PageDao pageDao)
	{
		this.pageDao = pageDao;
	}

}
