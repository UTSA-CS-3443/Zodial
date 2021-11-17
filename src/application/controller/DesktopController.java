package application.controller;


import javafx.event.EventHandler;
import java.util.ArrayList;

import application.model.EventList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class DesktopController {

    @FXML
    private Button logoutButton;

    @FXML
    private Button testButton;
    
    @FXML
    private VBox eventBox; 
    
    public void addEvent(ActionEvent event) {
    	EventList eList = new EventList();
    	eList.readEventList("data/exampleEvents.txt");
    	for(int i = 0;i < eList.getSize();i++) {
    		Label label = new Label(i + " " + eList.getEvent(i).toString());
    		label.setStyle("-fx-border-color: black;");
    		label.setOnMouseClicked(new EventHandler<MouseEvent>() {
    			public void handle(MouseEvent event) {
    				label.setText("deleted");
    				eList.removeEvent(1, "data/exampleEvents.txt");
    			}
    		});
    		eventBox.getChildren().add(label);
    	}
    }
  
}