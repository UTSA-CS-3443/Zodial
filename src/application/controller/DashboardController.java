package application.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import application.Main;
import application.model.EventList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class DashboardController implements Initializable {

    @FXML
    private Button logoutButton;

    @FXML
    private Button testButton;
    
    @FXML
    private ImageView profilePic;
    
    @FXML
    private Label usernameLabel;
    
    @FXML
    private VBox eventBox; 
    
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	EventList eList = new EventList();
    	eList.readEventList("data/exampleEvents.txt");
    	for(int i = 0;i < eList.size();i++) {
    		int j = i;
    		Label label = new Label(eList.getEvent(i).toString());
    		label.setStyle("-fx-border-color: black;");
    		label.setMinWidth(468);
    		label.setMinHeight(100);
    		label.setOnMouseClicked(event -> deleteEvent(eList,label,j));
    		eventBox.getChildren().add(label);
    	}
    }

    @FXML
	private void launchPictureSelector() {
		try {
			Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/ProfilePicture.fxml")));
			Main.stage.setScene(scene);
			Main.stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    public void addEvent(ActionEvent event) {
    	//TODO addEvents once the addEvent Scene and controller are completed.
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
    public void deleteEvent(EventList eList, Label label, int eventIndex){
		eList.removeEvent(eventIndex, "data/exampleEvents.txt");
		eList.addEventListToFile("data/exampleEvents.txt");
		eventBox.getChildren().clear();
		for(int i = 0;i < eList.size();i++) {
    		int j = i;
			Label label2 = new Label(eList.getEvent(i).toString());
    		label2.setStyle("-fx-border-color: black;");
    		label2.setMinWidth(468);
    		label2.setMinHeight(100);
    		label2.setOnMouseClicked(event -> deleteEvent(eList,label2,j));
    		eventBox.getChildren().add(label2);
    		}
	}
   }
 
