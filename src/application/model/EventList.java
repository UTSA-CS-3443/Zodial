package application.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EventList {
	private ArrayList<Event> userEvents;
	
	public EventList() {
		userEvents = new ArrayList<Event>();
		//need to add user field
		}
	public void readEventList(String filename) {
		try {
			File file = new File(filename);
			Scanner scan = new Scanner(file);
			while(scan.hasNext()) {
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				Event event = new Event(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4]);
				this.userEvents.add(event);
			}
			scan.close();
		}
		catch( IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param filename
	 */
	public void addEventListToFile(String filename) {
		try{
			FileWriter fw = new FileWriter(filename, false);
			for(int i = 0;i < userEvents.size();i++) {
				fw.write( this.userEvents.get(i).getTitle() + "," + this.userEvents.get(i).getDescript() + "," + this.userEvents.get(i).getDate() + "," + this.userEvents.get(i).getTime() + "," + this.userEvents.get(i).getLocal() + "\n");
			}
			fw.close();
		}
			catch( IOException e) {
				e.printStackTrace();
			}
	}
	/**
	 * @param index
	 * @param filename
	 */
	public void removeEvent(int index, String filename) {
		userEvents.remove(index);
		addEventListToFile(filename);
	}
	/**
	 * @return the userEvents
	 */
	public ArrayList<Event> getUserEvents() {
		return userEvents;
	}

	/**
	 * @param userEvents the userEvents to set
	 */
	public void setUserEvents(ArrayList<Event> userEvents) {
		this.userEvents = userEvents;
	}
	/**
	 * @param index
	 * @return an Event at that index
	 */
	public Event getEvent(int index) {
		return userEvents.get(index);
	}
	/**
	 * @return an int of the size of the userEvents
	 */
	public int size() {
		return userEvents.size();
	}
	public String toString() {
		String str = "";
		for(int i = 0;i < userEvents.size();i++) {
			 str += userEvents.get(i);
		}
		return str;
	}
}