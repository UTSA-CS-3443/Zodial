package application.model;


	/**
	 * @author CPGau
	 *
	 */
public class Event {
		private String title;
		private String description;
		private String location;
		private String date;
		private String time;
		private EventCategory category;

		public Event(String title, String description, String location, String date, String time, String categoryTitle) {
			this.title = title;
			this.description = description;
			this.location = location;
			this.date = date;
			this.time = time;
			this.category = new EventCategory(categoryTitle);
			this.category = new EventCategory(categoryTitle);
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getDate() {
			return date;
		}


		public void setDate(String date) {
			this.date = date;
		}


		public String getTime() {
			return time;
		}


		public void setTime(String time) {
			this.time = time;
		}


		public EventCategory getCategory() {
			return category;
		}


		public void setCategory(EventCategory category) {
			this.category = category;
		}

		@Override
		public String toString() {
			return this.getTitle() + "\n" + this.getDate() + "  " + this.getTime() + "\n" + this.getDescription();
		}
	}

