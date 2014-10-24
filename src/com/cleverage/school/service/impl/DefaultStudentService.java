package com.cleverage.school.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Required;

import com.cleverage.school.dao.StudentDao;
import com.cleverage.school.model.Student;
import com.cleverage.school.service.StudentService;


/**
 * Service for student.
 *
 * @author David OLMETA
 */
public class DefaultStudentService implements StudentService
{
	private StudentDao studentDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Student getStudentForId(final int id)
	{
		return getStudentDao().findStudentById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<Student> getStudents()
	{
		return getStudentDao().findStudents();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveStudent(final Student student)
	{
		getStudentDao().saveStudent(student);
	}

	/**
	 * @return the studentDao
	 */
	public StudentDao getStudentDao()
	{
		return studentDao;
	}

	/**
	 * @param studentDao
	 *           the studentDao to set
	 */
	@Required
	public void setStudentDao(final StudentDao studentDao)
	{
		this.studentDao = studentDao;
	}
}
