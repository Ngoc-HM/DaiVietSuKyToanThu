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

public class Festivals implements Serializable{
	int id;
	String festivalLunarDate;
	String festivalLocation;
	String festivalName;
	Characters festivalRelatedCharacter;
	
	public static ArrayList<Festivals> festivalsList = new ArrayList<Festivals>();
	
	public static ArrayList<Festivals> getFestivalsList() {
		return festivalsList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFestivalLunarDate() {
		return festivalLunarDate;
	}

	public void setFestivalLunarDate(String festivalLunarDate) {
		this.festivalLunarDate = festivalLunarDate;
	}

	public String getFestivalLocation() {
		return festivalLocation;
	}

	public void setFestivalLocation(String festivalLocation) {
		this.festivalLocation = festivalLocation;
	}

	public String getFestivalName() {
		return festivalName;
	}

	public void setFestivalName(String festivalName) {
		this.festivalName = festivalName;
	}

	public Characters getFestivalRelatedCharacter() {
		return festivalRelatedCharacter;
	}

	public void setFestivalRelatedCharacter(Characters festivalRelatedCharacter) {
		this.festivalRelatedCharacter = festivalRelatedCharacter;
	}

	public void addFestivals(Festivals c) {
        c.setId(festivalsList.size());
        festivalsList.add(c);
    }
}
