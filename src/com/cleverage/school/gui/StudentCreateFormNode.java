package com.cleverage.school.gui;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import com.cleverage.school.model.Student;
import com.cleverage.school.service.StudentService;
import com.cleverage.school.spring.SchoolSpring;


/**
 * Allows to display a form to create a new student.
 */
public class StudentCreateFormNode extends Parent
{
	private final TextField firstname;
	private final TextField lastname;
	private final DatePicker dateOfBirth;

	/**
	 * Default constructor.
	 */
	public StudentCreateFormNode()
	{
		// Create components.
		this.firstname = new TextField();
		this.lastname = new TextField();
		this.dateOfBirth = new DatePicker();

		// Create grid and get children.
		final GridPane gridPane = new GridPane();
		gridPane.setHgap(4);
		gridPane.setVgap(6);
		gridPane.setPadding(new Insets(18, 18, 18, 18));
		final ObservableList<Node> components = gridPane.getChildren();

		// Add first name line.
		final Label firstnameLabel = new Label("Firstname:");
		GridPane.setConstraints(firstnameLabel, 0, 0);
		components.add(firstnameLabel);

		GridPane.setConstraints(firstname, 1, 0);
		components.add(firstname);

		// Add last name line.
		final Label lastnameLabel = new Label("Lastname:");
		GridPane.setConstraints(lastnameLabel, 0, 1);
		components.add(lastnameLabel);

		GridPane.setConstraints(lastname, 1, 1);
		components.add(lastname);

		// Add the date of birth line.
		final Label dobLabel = new Label("Date Of Birth:");
		GridPane.setConstraints(dobLabel, 0, 2);
		components.add(dobLabel);

		GridPane.setConstraints(dateOfBirth, 1, 2);
		components.add(dateOfBirth);

		// Add the button and prepare the message label..
		final Button button = new Button("Save");
		final Label messageLabel = new Label();
		button.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(final ActionEvent event)
			{
				try
				{
					// Get the date value.
					final LocalDate localDate = dateOfBirth.getValue();
					Instant instant = null;
					if (localDate != null)
					{
						instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
					}

					// Create a student.
					final Student student = new Student(firstname.getText(), lastname.getText(), Date.from(instant));

					// Get the bean and save the student.
					final StudentService studentService = (StudentService) SchoolSpring.getInstance().getBean("studentService");

					studentService.saveStudent(student);
					messageLabel.setText("The student has been saved.");
				}
				catch (final Exception e)
				{
					messageLabel.setText(String.format("An error occured during the student saving process: %s", e.getMessage()));
				}
			}
		});

		GridPane.setConstraints(button, 0, 3);
		components.add(button);

		// Add a message label.
		GridPane.setConstraints(messageLabel, 1, 3);
		components.add(messageLabel);

		getChildren().addAll(gridPane);
	}
}
