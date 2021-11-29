package application.controller;

import java.io.IOException;

import application.Main;
import application.model.Event;
import application.model.EventCategory;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ModifyEventController implements EventHandler<MouseEvent> {
	@FXML private TextField titleField;
    @FXML private TextField descriptionField;
    @FXML private TextField dateField;
    @FXML private TextField timeStartField;
    @FXML private TextField timeEndField;
    @FXML private ComboBox<String> categoryChoices;
    @FXML private Button createButton;
   
    /**
     * Method: handle
     * ----------------
     * Handles onClick events that occur in the view. When the user clicks on
     * the Create or Cancel option in the view, the handle method will take
     * the user back to the Dashboard. If Create is selected, a new Event
     * is created and added to the user's list of events prior to being
     * navigated back to the dashboard.
     *
     *      @param event:   onClick event of a button/hyperlink in the view.
     *
     * Returns: N/A
     */
    @FXML
    @Override
    public void handle(MouseEvent event) {
        try {
            Node clickedOption = (Node) event.getSource();
            Parent root;
            if (!clickedOption.getId().equalsIgnoreCase("cancel")) {
                Event newEvent = new Event(
                        titleField.getText().trim(),
                        descriptionField.getText().trim(),
                        dateField.getText().trim(),
                        (timeStartField.getText().trim() + " - " + timeEndField.getText().trim()),
                        "local",
                        categoryChoices.getValue()
                );
              //  User.ACTIVE_USER.getEvents().add(newEvent);
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
    	//System.out.println(userEvent)
       
    	categoryChoices.getItems().addAll(EventCategory.getAllCategories());
        categoryChoices.setValue("Personal");
    }
    public void setEventData(Event event) {
    	titleField.setText(event.getTitle());
        descriptionField.setText(event.getDescription());
        dateField.setText(event.getDate());
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
            !dateField.getText().isEmpty() &&
            !timeStartField.getText().isEmpty() &&
            !timeEndField.getText().isEmpty()
        )
            createButton.setDisable(false);
    }
}


