package application.controller;

import java.net.URL;
import java.util.ResourceBundle;
import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class LoginController implements EventHandler<ActionEvent>, Initializable {
	
	@FXML Button loginPromptButton, signupPromptButton;
	@FXML AnchorPane mainPage, loginPrompt, signupPrompt;
	
	@Override
	public void initialize( URL location, ResourceBundle resources )
	{
		mainPage.setVisible(true);
		signupPrompt.setVisible(false);
		loginPrompt.setVisible(false);
		
	}
	
	
	@Override
	public void handle(ActionEvent event)
	{
		mainPage.setVisible(false);
		signupPrompt.setVisible(true);
	
	}
}
