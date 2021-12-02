package application.model;

import java.io.*;
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

    public static User ACTIVE_USER = new User();

    private String username;
    private String password;
    private String profilePic;
    private String name;
    private ArrayList<Event> events;

	/**
	 * Method: User
	 * ---------------------
	 * Empty constructor for the User class. Sets a default profile
	 * picture and creates an empty list of events for the User.
	 *
	 * Returns: new User
	 */
	public User() {
		this.profilePic = "avatar_0.png";
		this.events = new ArrayList<>();
	}

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
        this.profilePic = "avatar_0.png";
        this.events = new ArrayList<>();
    }

    /**
     * Method: validateUser
     * -------------------------
     * Checks if the inputed credentials match any of the users stored in the Users file.
     * 
     * 		@param username:		Username of a User.		
     * 		@param password:		Password of a User.
     * 		@param setActiveUser:	If the program should update the static variable, ACTIVE_USER.
     * 
     * Returns: Boolean statement.
     */
    public static boolean validateUser( String username, String password, boolean setActiveUser )
    {
//    	File dataDir = new File( "data");
    	
    	
    	File userFile = new File("data/users.txt");
    	
    	/*try {
			userFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	*/
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
						String name = input.next() + " " + input.next();
						String profilePic = input.next();
						
						if( setActiveUser )
						{
							ACTIVE_USER.setUsername(username);
							ACTIVE_USER.setPassword(password);
							ACTIVE_USER.setName(name);
							ACTIVE_USER.setProfilePic(profilePic);
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
    
    /**
     * Method: createUser
     * ----------------------
     * Creates a new User using the inputed credentials. Creates a file with username, and writes to the User's file.
     * 
     * 		@param username:		Username of a User.
     * 		@param password:		Password of a User.
     * 		@param firstName:		First name of a User.
     * 		@param lastName:		Last name of a User.
     * 
     * Returns: If the method could successfully read and write to the files. (Boolean Statment)
     */
    public static boolean createUser(String username, String password, String firstName, String lastName)
    {
    	File userFile = new File("data/" + username + ".txt");
    	try 
    	{
			userFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
    	
	    try 
	    {
	    	User newUser = new User(username, password, firstName + " " + lastName);
	    	FileWriter writer = new FileWriter("data/users.txt", true);
	    	writer.write(newUser.toString() + "\n");
	    	writer.close();
	    	return true;
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }


    	return false;

    }
    
    /**
     * Method: readEventList
     * -------------------------
     * Reads all the events stored in a file.
     * 
     * 		@param filename:		The name of the file.
     * 
     * Returns: N/A
     */
    public void readEventList(String filename) {
		try {
			File file = new File(filename);
			Scanner scan = new Scanner(file);
			while(scan.hasNext()) {
				String line = scan.nextLine();
				String[] tokens = line.split("#");
				Event event = new Event(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4], tokens[5]);

				this.events.add(event);
			}
			scan.close();
		}
		catch( IOException e) {
			e.printStackTrace();
		}
	}
    
    /**
     * Method: addEventListToFile
     * -----------------------------
     * Updates the events file for a user.
     * 
     * 		@param filename: The name of the file.
     * 
     * Returns: N/A
     */
    public void addEventListToFile(String filename) {
    	try{
			FileWriter fw = new FileWriter("data/" + filename, false);
			for(int i = 0;i < events.size();i++) {
				fw.write( this.events.get(i).getTitle() + "#" + this.events.get(i).getDescription() + "#" + this.events.get(i).getLocation() + "#" + this.events.get(i).getDate() + "#" + this.events.get(i).getTime() + "#" + this.events.get(i).getCategory().getTitle() + "\n");
			}
			fw.close();
		}
			catch( IOException e) {
				e.printStackTrace();
			}
	}
    
    /**
     * Method: removeEvent
     * ----------------------
     * Removes an event from a file.
     * 
     * 		@param index:		The index to remove.
     * 		@param filename:	The name of the file to remove from.
     * 
     * Returns: N/A
     */
    public void removeEvent(int index, String filename) {
		events.remove(index);
		addEventListToFile(filename);
	}

    
    /**
     * Method: updateProfilePicture
     * -------------------------------
     * Updates the contents of the User's file to contain a User's updated information.
     * 
     * 		@param newProfPicture:		The Path of the new Profile Picture.
     * 
     * Returns: N/A
     */
	public void updateProfilePicture(String newProfPicture) {
		try {
			String filePath = "data/users.txt";
			Scanner sc = new Scanner(new File(filePath));
			StringBuffer sb = new StringBuffer();
			
			while(sc.hasNextLine()) {
				sb.append(sc.nextLine() + System.lineSeparator());
			}
			sc.close();
			
			String usersFileContents = sb.toString();
			String oldLine = User.ACTIVE_USER.toString();
			User.ACTIVE_USER.setProfilePic(newProfPicture);
			String newLine = User.ACTIVE_USER.toString();
			
			usersFileContents = usersFileContents.replaceAll(oldLine, newLine);
			
			FileWriter fw = new FileWriter(filePath);
			fw.append(usersFileContents);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method: getEvent
	 * ------------------
	 * Getter for an Event for a User.
	 * 
	 * 		@param index: The index of the event to retrieve.
	 * 
	 * Returns: A User's event.
	 */
    public Event getEvent(int index) {
		return this.events.get(index);
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
    public String getProfilePic() {
        return profilePic;
    }

    /**
     * Method: setProfilePicPath
     * ---------------
     * Setter for local path of User's profile picture.
     *
     *      @param profilePic: 	Local path of User's profile picture
	 *                           	title.
     *
     * Returns: N/A
     */
    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
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

	public int getSize() {
		// TODO Auto-generated method stub
		return this.events.size();
	}

	/**
	 Method: toString
	 ------------------
	 Overridden toString method that returns a string representation of
	 the User class.

	 Returns: Stringified User class
	 */
	@Override
	public String toString() {
		return username + "," + password + "," + name.replace(" ", ",") + "," + profilePic;
	}

	
}
