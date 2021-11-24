package application.model;


	/**
	 * @author CPGau
	 *
	 */
public class Event {
		private String title;
		private String description;
		private String date;
		private String time;
		private String local;
		private EventCategory category;

		public Event(String title, String description, String date, String time, String local, String categoryTitle) {
			this.title = title;
			this.description = description;
			this.date = date;
			this.time = time;
			this.local = local;
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


		public String getLocal() {
			return local;
		}


		public void setLocal(String local) {
			this.local = local;
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

