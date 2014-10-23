package com.cleverage.school.model;

import com.cleverage.school.dao.StudentDao;
import com.cleverage.school.spring.SchoolSpring;


public class SchoolBookMain
{

	public static void main(final String[] args)
	{
		final StudentDao studentDao = (StudentDao) SchoolSpring.getInstance().getBean("studentDao");
		studentDao.getStudent(0);

		System.exit(0);
	}
}
