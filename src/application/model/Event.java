package application.model;


	/**
	 * Event is a Java class that represents an Event. It
	 * accounts for a title, description, location, date, time, and 
	 * event category.
	 *
	 *
	 *
	 * @author CPGau, TJ English (pcb408)
	 */
public class Event {
		private String title;
		private String description;
		private String location;
		private String date;
		private String time;
		private EventCategory category;

		
		
		/**
	     * Method: Event
	     * ---------------------
	     * Constructor for the Event class.
	     *
	     *      @param title: Title of the event.
	     *      @param description: Description of the event
	     *      @param location: location of the event
	     *      @param date: date of the event
	     *      @param time: time of the event
	     *      @param categoryTitle: category of the event
	     *
	     * Returns: new Event
	     */
		public Event(String title, String description, String location, String date, String time, String categoryTitle) {
			this.title = title;
			this.description = description;
			this.location = location;
			this.date = date;
			this.time = time;
			this.category = new EventCategory(categoryTitle);
		}
		
		/**
	     * Method: getTitle
	     * ---------------
	     * Getter for Event's title.
	     *
	     * Returns: Events's title (String)
	     */

		public String getTitle() {
			return title;
		}
		
		 /**
	     * Method: setTitle
	     * ---------------
	     * Setter for Event's title.
	     *
	     *      @param title:	Event's title.
	     *
	     * Returns: N/A
	     */

		public void setTitle(String title) {
			this.title = title;
		}
		
		/**
	     * Method: getDescription
	     * ---------------
	     * Getter for Event's description.
	     *
	     * Returns: Events's description (String)
	     */

		public String getDescription() {
			return description;
		}

		/**
	     * Method: setDescription
	     * ---------------
	     * Setter for Event's description.
	     *
	     *      @param description:	Event's description.
	     *
	     * Returns: N/A
	     */


		public void setDescription(String description) {
			this.description = description;
		}


		/**
	     * Method: getLocation
	     * ---------------
	     * Getter for Event's location.
	     *
	     * Returns: Events's location (String)
	     */
		
		public String getLocation() {
			return location;
		}

		/**
	     * Method: setLocation
	     * ---------------
	     * Setter for Event's location.
	     *
	     *      @param location:	Event's location.
	     *
	     * Returns: N/A
	     */
		
		public void setLocation(String location) {
			this.location = location;
		}


		/**
	     * Method: getDate
	     * ---------------
	     * Getter for Event's date.
	     *
	     * Returns: Events's date (String)
	     */
		
		public String getDate() {
			return date;
		}

		/**
	     * Method: setDate
	     * ---------------
	     * Setter for Event's date.
	     *
	     *      @param date:	Event's date.
	     *
	     * Returns: N/A
	     */

		public void setDate(String date) {
			this.date = date;
		}

		/**
	     * Method: getTime
	     * ---------------
	     * Getter for Event's time.
	     *
	     * Returns: Events's time (String)
	     */

		public String getTime() {
			return time;
		}

		/**
	     * Method: setTime
	     * ---------------
	     * Setter for Event's time.
	     *
	     *      @param time:	Event's time.
	     *
	     * Returns: N/A
	     */


		public void setTime(String time) {
			this.time = time;
		}


		/**
	     * Method: getCategory
	     * ---------------
	     * Getter for Event's category.
	     *
	     * Returns: Events's category)
	     */

		public EventCategory getCategory() {
			return category;
		}

		/**
	     * Method: setCateogy
	     * ---------------
	     * Setter for Event's category.
	     *
	     *      @param category:	Event's category.
	     *
	     * Returns: N/A
	     */

		public void setCategory(EventCategory category) {
			this.category = category;
		}
		

		/**
		 Method: toString
		 ------------------
		 Overridden toString method that returns a string representation of
		 the Event class.

		 Returns: Stringified Event class
		 */
		
		@Override
		public String toString() {
			return this.getDate() + " " + this.getTime() + "\n" + this.getLocation() + "\n" + this.getTitle() + "\n" + this.getDescription();
		}
		
	}

