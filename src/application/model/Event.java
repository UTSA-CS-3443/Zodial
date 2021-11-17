package application.model;


	/**
	 * @author CPGau
	 *
	 */
public class Event {
		private String title;
		private String descript;
		private String date;
		private String time;
		private String local;
		
		public Event(String title, String descript,String date, String time, String local){
			this.title = title;
			this.descript = descript;
			this.date = date;
			this.time = time;
			this.local = local;
		}
		
		@Override
		public String toString() {
			return "Event [Title=" + title + ", Descript=" + descript + ", date=" + date + ", Time=" + time + ", local="
					+ local + ", getTitle()=" + getTitle() + ", getDescript()=" + getDescript() + ", getDate()=" + getDate()
					+ ", getTime()=" + getTime() + ", getLocal()=" + getLocal() + "]";
		}

		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getDescript() {
			return descript;
		}


		public void setDescript(String descript) {
			this.descript = descript;
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

	}

