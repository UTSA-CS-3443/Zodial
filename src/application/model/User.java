package application.model;

import java.util.ArrayList;

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
