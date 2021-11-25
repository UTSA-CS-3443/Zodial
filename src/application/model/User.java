package application.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
					}
						
					
				}
				input.close();
				System.out.println( line );
			}
			
			fileReader.close();
			
			
			if( setActiveUser )
			{
				ACTIVE_USER.setUsername(username);
				ACTIVE_USER.setPassword(password);
			}
			
			return (userNameFound && passwordCorrect);
			
		}
		catch( IOException e)
		{
			System.out.println( "Error: Problem reading/writing with the file");
		}
    	
    	return false;
    }
    
    public static boolean createUser( String username, String password )
    {
    	File userFile = new File("data/users.txt");
    	try 
    	{
			userFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
    	
    	
    	if( User.validateUser(username, password, false) )
    	{
    		return false;
    	}
    	else
    	{
	    	try 
	    	{
	    		FileWriter writer = new FileWriter("data/users.txt", true);
	    		writer.write( username + "," + password + "\n");
	    		writer.close();
	    		return true;
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    	
    	}
    	
    	return false;
    	
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicPath() {
        return profilePicPath;
    }

    public void setProfilePicPath(String profilePicPath) {
        this.profilePicPath = profilePicPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
}
