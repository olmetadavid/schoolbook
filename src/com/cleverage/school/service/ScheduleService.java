package com.cleverage.school.service;

import java.util.Collection;

import com.cleverage.school.model.Schedule;


/**
 * Base interface for schedule service layer.
 *
 * @author David OLMETA
 */
public interface ScheduleService
{
	/**
	 * Get a schedule by id.
	 *
	 * @param id
	 *           The unique id.
	 * @return The schedule object.
	 */
	public Schedule getScheduleForId(final int id);

	/**
	 * Get schedules.
	 *
	 * @return The schedules list.
	 */
	public Collection<Schedule> getSchedules();


	/**
	 * Save a schedule for create or update.
	 *
	 * @param schedule
	 *           The schedule to create.
	 */
	public void saveSchedule(final Schedule schedule);
}
