package com.cleverage.school.dao;

import java.util.Collection;

import com.cleverage.school.model.Schedule;


/**
 * Base interface for schedule database access.
 *
 * @author David OLMETA
 */
public interface ScheduleDao
{
	/**
	 * Get a schedule by id.
	 *
	 * @param id
	 *           The unique id.
	 * @return The schedule object.
	 */
	public Schedule findScheduleById(final int id);

	/**
	 * Get schedules.
	 *
	 * @return The schedules list.
	 */
	public Collection<Schedule> findSchedules();


	/**
	 * Save a schedule for create or update.
	 *
	 * @param schedule
	 *           The schedule to create.
	 */
	public void saveSchedule(final Schedule schedule);
}
