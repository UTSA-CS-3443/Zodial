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

/**
 * LoginController is a java class that manages the GUI components of Login.fxml to allow interaction between the user
 * and the rest of the program. This class also calls the appropriate methods to create and verify a user's credentials.
 *  
 * @author Misael Paxtor(zlx030)
 */
public class LoginController implements EventHandler<ActionEvent>, Initializable {
	
	//GUI components
	@FXML Button signupPromptButton, signupPromptReturnButton, signupPromptNextButton;
	@FXML Button signupSubPromptReturnButton, signupSubPromptSignupButton;
	@FXML Button loginPromptReturnButton, loginPromptLoginButton, loginPromptButton;
	@FXML Label loginErrorLabel, signupErrorLabel, signupSubErrorLabel;
	@FXML AnchorPane mainPage, loginPrompt, signupPrompt, signupSubPrompt;
	@FXML TextField loginEmailField, signupEmailField, signupSubLastNameField, signupSubFirstNameField;
	@FXML PasswordField loginPasswordField, signupMainPasswordField, signupSubPasswordField;
	
	//Class variables
	private String inEmail;
	private String inPassword;
	private String firstName;
	private String lastName;
	
	/**
	 * Sets the GUI components for the home page.
	 */
	@Override
	public void initialize( URL location, ResourceBundle resources )
	{
		mainPage.setVisible(true);
		signupPrompt.setVisible(false);
		loginPrompt.setVisible(false);
		signupSubPrompt.setVisible(false);
		clearLabels();
	}
	
	/**
	 * Changes the the visible GUI components based the on the buttons pressed by the user.
	 * Prompts the user if invalid credentials were used or required textFields need to be filled in.
	 */
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
			inEmail = loginEmailField.getText();
			inPassword = loginPasswordField.getText();
			if( inEmail.equals("") || inPassword.equals("") )
			{
				loginErrorLabel.setText("Please complete all the fields.");
			}
			else
			{
				if ( User.validateUser( inEmail , inPassword, true) )
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
		else if ( event.getSource() == signupPromptNextButton )
		{
			if( signupEmailField.getText().equals("") || signupMainPasswordField.getText().equals("") || signupSubPasswordField.getText().equals("") )
			{
				signupErrorLabel.setText("Please complete all the fields.");
			}
			else
			{
				if( signupMainPasswordField.getText().equals(signupSubPasswordField.getText()) )
				{
					
					inEmail = signupEmailField.getText();
					inPassword = signupMainPasswordField.getText();
					if( User.validateUser(inEmail, inPassword, false) )
					{
						clearLabels();
						signupErrorLabel.setText("User already exists");
					}
					else
					{
						signupPrompt.setVisible(false);
						signupSubPrompt.setVisible(true);
					}
					
					
				} 
				else 
				{
					signupErrorLabel.setText("Passwords do not match. Try Again.");
				}
			}
			
		}
		else if( event.getSource() == signupSubPromptReturnButton )
		{
			clearLabels();
			signupSubPrompt.setVisible(false);
			signupPrompt.setVisible(true);
		}
		else if( event.getSource() == signupSubPromptSignupButton )
		{
			firstName = signupSubFirstNameField.getText();
			lastName = signupSubLastNameField.getText();
			if( firstName.equals("") || lastName.equals("") )
			{
				signupSubErrorLabel.setText("Please complete all the fields.");
			}
			else
			{
				User.createUser(inEmail, inPassword, firstName, lastName);
				clearLabels();
				signupSubPrompt.setVisible(false);
				mainPage.setVisible(true);
			}
		}
		
		
		
	
	}
	
	/**
	 * Clears all textFields, labels, and passwordFields in Login.fxml.
	 */
	public void clearLabels()
	{
		signupEmailField.setText("");
		signupMainPasswordField.setText("");
		signupSubPasswordField.setText("");
		signupErrorLabel.setText("");
		loginEmailField.setText("");
		loginPasswordField.setText("");
		loginErrorLabel.setText("");
		signupSubFirstNameField.setText("");
		signupSubLastNameField.setText("");
	}
	
}
