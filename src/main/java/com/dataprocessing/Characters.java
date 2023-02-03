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

public class Characters implements Serializable{
	int id;
	String name;
	String location;
	String period;
	String description;
	String bornYear;
	String diedYear;
	
	public static ArrayList<Characters> charactersList = new ArrayList<Characters>();
	
	public static ArrayList<Characters> getCharactersList() {
		return charactersList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBornYear() {
		return bornYear;
	}

	public void setBornYear(String bornYear) {
		this.bornYear = bornYear;
	}

	public String getDiedYear() {
		return diedYear;
	}

	public void setDiedYear(String diedYear) {
		this.diedYear = diedYear;
	}
	
    public void addCharacter(Characters c) {
        c.setId(charactersList.size());
        charactersList.add(c);
    }

	public void display() {
        System.out.println("------- Character List -------");
        for (Characters ch : charactersList){
            System.out.printf("%5d %-20s %-15s \n", ch.getId(), ch.getName(), ch.getPeriod());
        }
    }
    
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        FileReader reader = new FileReader("D:\\Resources\\SampleDataBase.json");
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject characterObject = (JSONObject) obj;
            
            JSONArray characterArray = (JSONArray)characterObject.get("character");
            
            for(int i=0 ; i<characterArray.size() ; i++) {
            	JSONObject jcharacter = (JSONObject)characterArray.get(i);
            	
            	Characters ch = new Characters();
            	
            	ch.setName((String) jcharacter.get("name"));
            	ch.setPeriod((String) jcharacter.get("period"));
            	ch.setBornYear((String) jcharacter.get("bornYear"));
            	
            	ch.addCharacter(ch);
            }
            //display();
            System.out.println("------- (example) Character List -------");
            //for (int i=0; i<charactersList.size();i++) {
            for (Characters i : charactersList){
            	System.out.printf("%5d %-20s %-15s \n", i.getId(), i.getName(), i.getBornYear());
            	//System.out.println(charactersList.get(i));
            }
    }
}
