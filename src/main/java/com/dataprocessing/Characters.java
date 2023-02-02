package dataprocessing;

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
            System.out.printf("%-20s %-15s \n", ch.getName(), ch.getPeriod());
        }
    }
    
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        FileReader reader = new FileReader("D:\\Resources\\Character.json");
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject characterObject = (JSONObject) obj;
            
            JSONArray array = (JSONArray)characterObject.get("character");
            
            for(int i=0 ; i<50 ; i++) {
            	JSONObject jcharacter = (JSONObject)array.get(i);
            	
            	String name = (String) jcharacter.get("name");
            	String period = (String) jcharacter.get("period");
            	
            	Characters ch = new Characters();
            	
            	ch.setName(name);
            	ch.setPeriod(period);
            	
            	ch.addCharacter(ch);
            }
            //display();
            System.out.println("------- (example) Character List -------");
            for (Characters i : charactersList){
                System.out.printf("%-20s %-15s \n", i.getName(), i.getPeriod());
            }
    }
}
