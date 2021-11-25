package application.controller;

import java.net.URL;
import java.util.ResourceBundle;
import application.Main;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController implements EventHandler<ActionEvent>, Initializable {
	
	@FXML Button signupPromptButton, signupPromptReturnButton, signupPromptSignupButton;
	@FXML Button loginPromptReturnButton, loginPromptLoginButton, loginPromptButton;
	@FXML Label loginErrorLabel, signupErrorLabel;
	@FXML AnchorPane mainPage, loginPrompt, signupPrompt;
	@FXML TextField loginEmailField, signupEmailField;
	@FXML PasswordField loginPasswordField, signupMainPasswordField, signupSubPasswordField;
	
	private String inEmail;
	private String inPassword;
	
	@Override
	public void initialize( URL location, ResourceBundle resources )
	{
		mainPage.setVisible(true);
		signupPrompt.setVisible(false);
		loginPrompt.setVisible(false);
		clearLabels();
	}
	
	
	@Override
	public void handle(ActionEvent event)
	{
		if( event.getSource() == loginPromptButton )
		{
			mainPage.setVisible(false);
			loginPrompt.setVisible(true);
		}
		else if ( event.getSource() == signupPromptButton )
		{
			mainPage.setVisible(false);
			signupPrompt.setVisible(true);
		}
		else if ( event.getSource()  == signupPromptReturnButton )
		{
			mainPage.setVisible(true);
			signupPrompt.setVisible(false);
		}
		else if ( event.getSource() == loginPromptReturnButton )
		{
			mainPage.setVisible(true);
			loginPrompt.setVisible(false);
			clearLabels();
		}
		else if ( event.getSource() == loginPromptLoginButton )
		{
			if( loginEmailField.getText().equals("") || loginPasswordField.getText().equals("") )
			{
				loginErrorLabel.setText("Please complete all the fields.");
			}
			else
			{
				if ( User.validateUser(loginEmailField.getText(), loginPasswordField.getText(), true) )
				{
					try {
						Parent root = FXMLLoader.load(getClass().getResource("../view/Dashboard.fxml"));
						Main.stage.setScene(new Scene(root, 800, 800));
						Main.stage.show();
						
					} catch(Exception e) {
						e.printStackTrace();
					}
					
				}
				else
				{
					clearLabels();
					loginErrorLabel.setText("Invalid Credentials");
				
				}
			}
		}
		else if ( event.getSource() == signupPromptSignupButton )
		{
			if( signupEmailField.getText().equals("") || signupMainPasswordField.getText().equals("") || signupSubPasswordField.getText().equals("") )
			{
				signupErrorLabel.setText("Please complete all the fields.");
			}
			else
			{
				if( signupMainPasswordField.getText().equals(signupSubPasswordField.getText()) )
				{
					//System.out.println( "Creating a user with the credentials " + signupEmailField.getText() + " " + signupMainPasswordField.getText() + " " + signupSubPasswordField.getText() );
					mainPage.setVisible(true);
					signupPrompt.setVisible(false);
					signupErrorLabel.setText("");
					if( !User.createUser(signupEmailField.getText(), signupMainPasswordField.getText()) )
					{
						signupErrorLabel.setText("User all ready exists");
					}
					clearLabels();
				} 
				else 
				{
					signupErrorLabel.setText("Passwords do not match. Try Again.");
				}
			}
			
		}
		
		
		//System.out.println(event.getSource());
	
	}
	
	public void clearLabels()
	{
		signupEmailField.setText("");
		signupMainPasswordField.setText("");
		signupSubPasswordField.setText("");
		signupErrorLabel.setText("");
		loginEmailField.setText("");
		loginPasswordField.setText("");
		loginErrorLabel.setText("");
	}
	
}
