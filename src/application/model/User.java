package application.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * User is a Java class that represents a user of the Zodial application. It
 * contains information required from a user to use the app, including a
 * username, password, and a list of any events that user has created. This
 * class also tracks the currently active user via a static field ACTIVE_USER.
 *
 * @author TJ English (pcb408), Misael Paxtor (zlx030)
 * UTSA CS 3443 - Zodial (Group Project)
 * Fall 2021
 */
public class User {

    // Creating for testing purposes -- will be set based on Userpool generated from file
    public static User ACTIVE_USER = new User(
            "test",
            "testp",
            "Mr Test"
    );

    private String username;
    private String password;
    private String profilePicPath;
    private String name;
    private ArrayList<Event> events;

	/**
	 * Method: User
	 * ---------------------
	 * Constructor for the User class. Profile picture path and list of
	 * events is set to a default value by this constructor.
	 *
	 *      @param username: 	Username of a User.
	 *      @param password: 	Password of a User.
	 *      @param name: 		Real name of a User.
	 *
	 * Returns: new User
	 */
    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.profilePicPath = "@../../../data/blank-profile-picture-973460_1280.png";
        this.events = new ArrayList<>();
    }

    public static boolean validateUser( String username, String password, boolean setActiveUser )
    {
    	File userFile = new File( "data/users.txt");
    	try {
			userFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	try
		{
			BufferedReader fileReader = new BufferedReader( new FileReader( userFile ) );
			Scanner input = null;
			String line = null;
			boolean userNameFound = false;
			boolean passwordCorrect = false;
			while( (line = fileReader.readLine()) != null )
			{
				input = new Scanner(line);
				input.useDelimiter(",");
				String inAccName = input.next();
				if( (inAccName.equals(username)) )
				{
					userNameFound = true;
					String inAccPassword = input.next();
					if( (inAccPassword.equals(password)))
					{
						passwordCorrect = true;	
						String name = input.next() + input.next();
						
						if( setActiveUser )
						{
							ACTIVE_USER.setUsername(username);
							ACTIVE_USER.setPassword(password);
							ACTIVE_USER.setName(name);
						}
						
					}
						
					
				}
				input.close();
			}
			
			fileReader.close();
			
			
			
			
			return (userNameFound && passwordCorrect);
			
		}
		catch( IOException e)
		{
			System.out.println( "Error: Problem reading/writing with the file");
		}
    	
    	return false;
    }
    
    public static boolean createUser( String username, String password, String firstName, String lastName )
    {
    	File userFile = new File("data/users.txt");
    	try 
    	{
			userFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
    	
	    try 
	    {
	    	FileWriter writer = new FileWriter("data/users.txt", true);
	    	writer.write( username + "," + password + "," + firstName + "," + lastName + "\n");
	    	writer.close();
	    	return true;
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	    	
    	
    	return false;
    	
    }
    
    /**
     * Method: getUsername
     * ---------------
     * Getter for User's username.
     *
     * Returns: User's username (String)
     */
    public String getUsername() {
        return username;
    }

	/**
	 * Method: setUsername
	 * ---------------
	 * Setter for User's username.
	 *
	 *      @param username: 	User's username.
	 *
	 * Returns: N/A
	 */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Method: getTitle
     * ---------------
     * Getter for User's password.
     *
     * Returns: User's password (String)
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method: setPassword
     * ---------------
     * Setter for User's password.
     *
     *      @param password:	User's password.
     *
     * Returns: N/A
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method: getProfilePicPath
     * ---------------
     * Getter for local path of User's profile picture.
     *
     * Returns: Local path of User's profile picture title (String)
     */
    public String getProfilePicPath() {
        return profilePicPath;
    }

    /**
     * Method: setProfilePicPath
     * ---------------
     * Setter for local path of User's profile picture.
     *
     *      @param profilePicPath: 	Local path of User's profile picture
	 *                           	title.
     *
     * Returns: N/A
     */
    public void setProfilePicPath(String profilePicPath) {
        this.profilePicPath = profilePicPath;
    }

    /**
     * Method: getName
     * ---------------
     * Getter for User's name.
     *
     * Returns: User's name (String)
     */
    public String getName() {
        return name;
    }

    /**
     * Method: setTitle
     * ---------------
     * Setter for User's name.
     *
     *      @param name: 	User's name.
     *
     * Returns: N/A
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method: getEvents
     * ---------------
     * Getter for User's list of Events.
     *
     * Returns: User's list of Events (ArrayList<Event>)
     */
    public ArrayList<Event> getEvents() {
        return events;
    }

    /**
     * Method: setTitle
     * ---------------
     * Setter for User's list of Events.
     *
     *      @param events: 	User's list of Events.
     *
     * Returns: N/A
     */
    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
}
