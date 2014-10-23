package com.cleverage.school;

import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cleverage.school.dao.HibernateUtil;
import com.cleverage.school.model.Student;


public class SchoolBookMain extends Application
{

	public static void main(final String[] args)
	{
		launch(args);
		System.exit(0);
	}

	@Override
	public void start(final Stage primaryStage) throws Exception
	{

		// A SessionFactory is set up once for an application
		final SessionFactory sessionFactory = HibernateUtil.createSessionFactory();

		// create a couple of students...
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new Student("David", "OLMETA"));
		session.getTransaction().commit();
		session.close();

		primaryStage.setTitle("Hello World!");
		final Button btn = new Button();
		btn.setText("Say 'Hello World'");
		btn.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(final ActionEvent event)
			{
				System.out.println("Hello World!");
				final Session session = sessionFactory.openSession();
				session.beginTransaction();
				final List<Student> result = session.createQuery("from Student").list();
				for (final Student student : result)
				{
					primaryStage.setTitle("Hello " + student.getFirstname() + " " + student.getLastname() + "!");
					System.out.println("Student: " + student.getFirstname() + " " + student.getLastname());
				}
				session.getTransaction().commit();
				session.close();
			}
		});

		final StackPane root = new StackPane();
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}
}
