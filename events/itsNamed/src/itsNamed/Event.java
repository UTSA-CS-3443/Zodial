/**
 * 
 */
package itsNamed;

/**
 * @author CPGau
 *
 */
public class Event {
	private String Title;
	private String Descript;
	private String date;
	private String Time;
	private String local;
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	Event(){
		
	}
	Event(String date, String Title){
		
	}
	
	Event(String date, String Title, String Time){
		
	}
	Event(String date, String Title, String Time, String Descript){
		
	}
	
	
	@Override
	public String toString() {
		return "Event [Title=" + Title + ", Descript=" + Descript + ", date=" + date + ", Time=" + Time + ", local="
				+ local + ", getTitle()=" + getTitle() + ", getDescript()=" + getDescript() + ", getDate()=" + getDate()
				+ ", getTime()=" + getTime() + ", getLocal()=" + getLocal() + "]";
	}


	Event(String date, String Title, String Time, String Descript, String local){
	
		
	}
	

	
	


	public String getTitle() {
		return Title;
	}


	public void setTitle(String title) {
		Title = title;
	}


	public String getDescript() {
		return Descript;
	}


	public void setDescript(String descript) {
		Descript = descript;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTime() {
		return Time;
	}


	public void setTime(String time) {
		Time = time;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}

}
