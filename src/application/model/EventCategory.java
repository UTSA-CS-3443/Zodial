package application.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * EventCategory is a Java class that represents the category of an Event. It
 * accounts for a category title & a hex code defining the color associated
 * with the category, which is displayed in the Event details.
 *
 * @author TJ English (pcb408)
 * UTSA CS 3443 - Zodial (Group Project)
 * Fall 2021
 */
public class EventCategory {
    private String title;
    private String colorHexCode;

    /**
     * Method: EventCategory
     * ---------------------
     * Constructor for the EventCategory class.
     *
     *      @param title: Title of the category.
     *
     * Returns: new EventCategory
     */
    public EventCategory(String title) {
        this.title = title;
        this.colorHexCode = colorPicker(title);
    }

    /**
     * Method: getTitle
     * ---------------
     * Getter for EventCategory title.
     *
     * Returns: EventCategory title (String)
     */
    public String getTitle() {
        return title;
    }

    /**
     * Method: setTitle
     * ---------------
     * Setter for EventCategory title.
     *
     *      @param title: EventCategory title.
     *
     * Returns: N/A
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Method: getColorHexCode
     * ---------------
     * Getter for color hex code associated with a category.
     *
     * Returns: Color hex code associated with a category (String)
     */
    public String getColorHexCode() {
        return colorHexCode;
    }

    /**
     * Method: setColorHexCode
     * ---------------
     * Setter for color hex code associated with a category.
     *
     *      @param colorHexCode: Color hex code associated with a category.
     *
     * Returns: N/A
     */
    public void setColorHexCode(String colorHexCode) {
        this.colorHexCode = colorHexCode;
    }

    /**
     * Method: getAllCategories
     * ------------------
     * Creates and returns an ObservableList of String values that
     * define all possible categories a user can choose when adding
     * a new Event.
     *
     * Returns: List of possible Event categories (ObservableList<String>)
     */
    public static ObservableList<String> getAllCategories() {
        return FXCollections.observableArrayList(
                "Personal",
                "Work",
                "Kids Activities",
                "Holiday",
                "Other"
        );
    }

    /**
     * Method: colorPicker
     * ------------------
     * Using the provided category title, this method returns the
     * corresponding color hex code for the category.
     *
     *      @param title:    Title of the Event category.
     *
     * Returns: Color hex code (String)
     */
    private String colorPicker(String title) {
        String colorHexCode;

        switch (title) {
            case "Personal":
                colorHexCode = "#00ffea";
                break;
            case "Holiday":
                colorHexCode = "#039403";
                break;
            case "Work":
                colorHexCode = "#0202d6";
                break;
            case "Kids Activities":
                colorHexCode = "#eb4034";
                break;
            default:
                colorHexCode = "#ffcc00";
        }

        return colorHexCode;
    }
}
