package com.cleverage.school.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Required;

import com.cleverage.school.dao.ScheduleDao;
import com.cleverage.school.model.Schedule;
import com.cleverage.school.service.ScheduleService;


/**
 * Service for schedule.
 *
 * @author David OLMETA
 */
public class DefaultScheduleService implements ScheduleService
{
	private ScheduleDao scheduleDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Schedule getScheduleForId(final int id)
	{
		return getScheduleDao().findScheduleById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<Schedule> getSchedules()
	{
		return getScheduleDao().findSchedules();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveSchedule(final Schedule schedule)
	{
		getScheduleDao().saveSchedule(schedule);
	}

	/**
	 * @return the scheduleDao
	 */
	public ScheduleDao getScheduleDao()
	{
		return scheduleDao;
	}

	/**
	 * @param scheduleDao
	 *           the scheduleDao to set
	 */
	@Required
	public void setScheduleDao(final ScheduleDao scheduleDao)
	{
		this.scheduleDao = scheduleDao;
	}

}
