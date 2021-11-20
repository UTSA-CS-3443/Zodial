package application.controller;


import javafx.event.EventHandler;
import application.Main;
import application.model.EventList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class DashboardController {

    @FXML
    private Button logoutButton;

    @FXML
    private Button testButton;
    
    @FXML
    private VBox eventBox; 
    
    /* 
     *  This code addsEvents from the the exampleEvents.txt file I created.
     *  EventList is a class I made that holds the events in a ArrayList
     *  the for loop goes though the VBox and adds a label for each event
     *  I'd like to make the labels look nicer so if you want to try and work on that.
     */
    public void addEvent(ActionEvent event) {
    	eventBox.getChildren().clear();
    	EventList eList = new EventList();
    	eList.readEventList("data/exampleEvents.txt");
    	for(int i = 0;i < eList.getSize();i++) {
    		Label label = new Label(eList.getEvent(i).toString());
    		label.setStyle("-fx-border-color: black;");
    		label.setMinWidth(468);
    		label.setMinHeight(100);
    		/*this sets a function to each label once they are clicked
    		 *  right now clicking them just sets the text to say deleted
    		 *  what I would like to do is have a popup windo that ask whether
    		 *  or not the user would like to delete the event before deleting
    		 *  I havent actually worked out how to actually delete the event from 
    		 * the file yet.
    		 * 
    		 */
    		label.setOnMouseClicked(new EventHandler<MouseEvent>() {
    			public void handle(MouseEvent event) {
    				label.setText("deleted");
    			}
    		});
    		eventBox.getChildren().add(label);
    	}
    }
    public void logout(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
    }
  
}