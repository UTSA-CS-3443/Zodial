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
	public String toString() {
		String str = "";
		for(int i = 0;i < userEvents.size();i++) {
			str += userEvents.get(i);
		}
		return str;
	}
	public Event getEvent(int index) {
		return userEvents.get(index);
	}
	public int getSize() {
		return userEvents.size();
	}
	public void addEvent() {
		//TODO add method to add event and add it to file;
	}
	public void removeEvent(int index, String filename) {
		userEvents.remove(index);
		addEventListToFile(filename);
	}
	/*
	 * 
	 */
	public void addEventListToFile(String filename) {
		try{
			FileWriter fw = new FileWriter(filename,true);
			for(int i = 0;i < userEvents.size();i++) {
				fw.write( this.userEvents.get(i).getTitle() + "," + this.userEvents.get(i).getDescript() + "," + this.userEvents.get(i).getDate() + "," + this.userEvents.get(i).getTime() + "," + this.userEvents.get(i).getLocal() + "\n");
			}
			fw.close();
		}
			catch( IOException e) {
				e.printStackTrace();
			}
	}
}