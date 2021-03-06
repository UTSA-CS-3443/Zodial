/**@author Aylene Santillan (hrv061), TJ English (pcb408),
 * UTSA CS 3443 - Zodial (Group Project)
 * Fall 2021
 */


package application.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.Main;
import application.model.Event;
import application.model.EventCategory;
import application.model.User;
import application.controller.EventCreationController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class ModifyEventController implements EventHandler<ActionEvent> {
	@FXML private TextField titleField;
    @FXML private TextField descriptionField;
    @FXML private TextField dateField;
    @FXML private TextField timeStartField;
    @FXML private TextField timeEndField;
    @FXML private TextField locationField;
    @FXML private ComboBox<String> categoryChoices;
    @FXML private Button createButton;
    @FXML private Button cancelButton;

   
    /**
     * Method: handle
     * ----------------
     * Handles onClick events that occur in the view. When the user clicks on
     * the Save or Cancel option in the view, the handle method will take
     * the user back to the Dashboard. If Save is selected, the modified Event
     * is saved and added to the user's list of events prior to being
     * navigated back to the dashboard.
     *
     *      @param event:   onClick event of a button/hyperlink in the view.
     *
     * Returns: N/A
     */
    @FXML
    @Override
    public void handle(ActionEvent event) {
        try {
            Node clickedOption = (Node) event.getSource();
            Parent root;
            if (!clickedOption.getId().equalsIgnoreCase("cancel")) {
             
                Event newEvent = new Event(
                        titleField.getText().trim(),
                        descriptionField.getText().trim(),
                        locationField.getText().trim(),
                        dateField.getText().trim(),
                        (timeStartField.getText().trim() + " - " + timeEndField.getText().trim()),
                        categoryChoices.getValue()
                );
                ArrayList<Event> userEvents = User.ACTIVE_USER.getEvents();
                for (Event userEvent : userEvents) {
                	if (userEvent.getTitle().equalsIgnoreCase(newEvent.getTitle())) {
                		userEvents.remove(userEvent);
                		userEvents.add(newEvent);
                		break;
                	}
                }
                User.ACTIVE_USER.setEvents(userEvents);
                User.ACTIVE_USER.addEventListToFile(User.ACTIVE_USER.getUsername() + ".txt");
            }
            root = FXMLLoader.load(getClass().getResource("../view/Dashboard.fxml"));
            Scene scene = new Scene(root);
            Main.stage.setScene(scene);
            Main.stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Method: initialize
     * -----------------
     * Populates the category dropdown menu in the view with all
     * possible categories.
     *
     * Returns: N/A
     */
    @FXML
    public void initialize() {       
    	categoryChoices.getItems().addAll(EventCategory.getAllCategories());
        categoryChoices.setValue("Personal");
        
    }
    
    /**
     * Method: setEventData
     * -----------------
     * Sets the data of the event that is being modified
     * 
     *
     * Returns: N/A
     */
    public void setEventData(Event event) {
    	String[] times = event.getTime().split("-");
    	
    	titleField.setText(event.getTitle());
        descriptionField.setText(event.getDescription());
        locationField.setText(event.getLocation());
        dateField.setText(event.getDate());
        timeStartField.setText(times[0].trim());
        timeEndField.setText(times[1].trim());
    }

    /**
     * Method: enableCreateButton
     * -----------------
     * Checks if all text fields of event creation are populated with
     * values. If every field has a value (the category selection is
     * set to 'Personal' by default), the Create button is enabled,
     * allowing the user to continue creating the new event.
     *
     * Returns: N/A
     */
    @FXML
    public void enableCreateButton() {
        if (
            !titleField.getText().isEmpty() &&
            !descriptionField.getText().isEmpty() &&
            !locationField.getText().isEmpty() &&
            !dateField.getText().isEmpty() &&
            !timeStartField.getText().isEmpty() &&
            !timeEndField.getText().isEmpty() &&
            !categoryChoices.getValue().isEmpty()
        )
            createButton.setDisable(false);
    }
}


