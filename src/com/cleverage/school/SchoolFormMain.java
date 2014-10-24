package com.cleverage.school;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.cleverage.school.gui.StudentCreateFormNode;


@SuppressWarnings("restriction")
public class SchoolFormMain extends Application
{

	public static void main(final String[] args)
	{
		launch(args);
		System.exit(0);
	}

	@Override
	public void start(final Stage primaryStage) throws Exception
	{
		primaryStage.setScene(new Scene(new StudentCreateFormNode(), 320, 200));

		primaryStage.show();
	}
}
