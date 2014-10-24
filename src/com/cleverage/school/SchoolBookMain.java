package com.cleverage.school;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import com.cleverage.school.dao.StudentDao;
import com.cleverage.school.model.Student;
import com.cleverage.school.spring.SchoolSpring;


public class SchoolBookMain extends Application
{

	public static void main(final String[] args)
	{
		launch(args);
		System.exit(0);
	}

	@SuppressWarnings("restriction")
	@Override
	public void start(final Stage primaryStage) throws Exception
	{
		primaryStage.setTitle("Hello World!");
		final Button btn = new Button();
		btn.setText("Say 'Hello World'");
		btn.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(final ActionEvent event)
			{
				System.out.println("Hello World!");
				final StudentDao studentDao = (StudentDao) SchoolSpring.getInstance().getBean("studentDao");
				final Student student = studentDao.getStudent(0);
				primaryStage.setTitle("Hello " + student.getFirstname() + " " + student.getLastname() + "!");
				System.out.println("Student: " + student.getFirstname() + " " + student.getLastname());
			}
		});

		final StackPane root = new StackPane();
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}
}
