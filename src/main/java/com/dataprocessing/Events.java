package com.dataprocessing;

import java.io.Serializable;
import java.util.ArrayList;

public class Events implements Serializable {
	int id;
	String eventName;
	String eventContent;
	ArrayList<Relics> eventLocation;
	ArrayList<Characters> eventPeople;

	public static ArrayList<Events> eventsList = new ArrayList<Events>();

	public static ArrayList<Events> getEventsList() {
		return eventsList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventContent() {
		return eventContent;
	}

	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}

	public ArrayList<Relics> getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(ArrayList<Relics> eventsLocationList) {
		this.eventLocation = eventsLocationList;
	}

	public ArrayList<Characters> getEventPeople() {
		return eventPeople;
	}

	public void setEventPeople(ArrayList<Characters> eventPeople) {
		this.eventPeople = eventPeople;
	}

	public void addEvents(Events c) {
		c.setId(eventsList.size());
		eventsList.add(c);
	}
}
