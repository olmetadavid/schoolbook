package com.cleverage.school.service;

import java.util.Collection;

import com.cleverage.school.model.Student;


/**
 * Base interface for student service layer.
 *
 * @author David OLMETA
 */
public interface StudentService
{
	/**
	 * Get a student by id.
	 *
	 * @param id
	 *           The unique id.
	 * @return The student object.
	 */
	public Student getStudentForId(final int id);

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
