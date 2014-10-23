package com.cleverage.school.dao;

import java.util.Collection;

import com.cleverage.school.model.Student;


/**
 * Base interface for student database access.
 * 
 * @author David OLMETA
 */
public interface StudentDao
{
	/**
	 * Get a student by id.
	 * 
	 * @param id
	 *           The unique id.
	 * @return The student object.
	 */
	public Student getStudent(final int id);

	/**
	 * Get students.
	 * 
	 * @return The students list.
	 */
	public Collection<Student> getStudents();


	/**
	 * Save a student for create or update.
	 * 
	 * @param student
	 *           The student to create.
	 */
	public void saveStudent(final Student student);
}
