package application.controller;


import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import application.Main;
import application.model.EventList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class DashboardController implements Initializable {

    @FXML
    private Button logoutButton;

    @FXML
    private Button testButton;
    
    @FXML
    private Pane deletePane;
    
    @FXML
    private Button yesButton;
    
    @FXML
    private Button cancelButton;
    
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
    		label.setStyle("-fx-border-width: 2; -fx-border-radius: 2;-fx-border-color: #000000;-fx-font-size: 14;-fx-font-weight: bold;-fx-background-color: "+ eList.getEvent(i).getCategory() + ";");
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
    	ButtonType modify = new ButtonType("Modify",ButtonBar.ButtonData.OTHER);
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	
    	alert.setHeaderText("Delete Confirmation");
    	
    	alert.setContentText("Do you want to delete event- " + eList.getEvent(eventIndex).getTitle() + "?");
    	alert.getButtonTypes().addAll(modify);
    	alert.getDialogPane().getChildren().forEach(node -> {
    	    if (node instanceof ButtonBar) {
    	        ButtonBar buttonBar = (ButtonBar) node;
    	        buttonBar.getButtons().forEach(possibleButtons -> {
    	            if (possibleButtons instanceof Button) {
    	                Button b = (Button) possibleButtons;
    	                    b.setStyle("-fx-border-width: 2; -fx-border-radius: 2; -fx-background-color: #fdaf14; -fx-border-color: #000000;-fx-font-size: 14;-fx-font-weight: bold");	                
    	            }
    	        });
    	    }
    	});
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
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
    	} else if(result.get() == modify) {
    		application.model.Event userEvent = eList.getEvent(eventIndex);
    		//System.out.println(eList.getEvent(eventIndex).toString());
    		try {
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ModifyEvent.fxml"));
    			Parent root = (Parent) loader.load();
    			ModifyEventController modifyController = loader.getController();
    		
    			modifyController.setEventData(userEvent);
    			Main.stage.setScene(new Scene(root, 800, 800));
    			Main.stage.show();
    		}catch (Exception e) {
    			e.printStackTrace();
    		}	
    		}
    	else {
    	    // ... user chose CANCEL or closed the dialog
    	}
    	
	}
   }
 
