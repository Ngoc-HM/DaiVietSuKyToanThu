package com.dataprocessing;

import java.io.Serializable;
import java.util.ArrayList;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Relics implements Serializable{
	int id;
	String relicName;
	String relicDescription;
	ArrayList<Events> relicEvent;
	
	public static ArrayList<Relics> relicsList = new ArrayList<Relics>();
	
	public static ArrayList<Relics> getRelicsList() {
		return relicsList;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRelicName() {
		return relicName;
	}

	public void setRelicName(String relicName) {
		this.relicName = relicName;
	}

	public String getRelicDescription() {
		return relicDescription;
	}

	public void setRelicDescription(String relicDescription) {
		this.relicDescription = relicDescription;
	}

	public ArrayList<Events> getRelicEvent() {
		return relicEvent;
	}

	public void setRelicEvent(ArrayList<Events> relicEvent) {
		this.relicEvent = relicEvent;
	}

	public void addRelics(Relics c) {
        c.setId(relicsList.size());
        relicsList.add(c);
    }
}
