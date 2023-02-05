package com.dataprocessing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Periods implements Serializable{
	int id;
	String periodName;
	String periodTime;
	Periods periodPredecessor;
	Periods periodSuccessor;
	String periodCapital;
    Characters periodFirstEmperor;
    Characters periodLastEmperor;
    String periodReligion;
	
	public static ArrayList<Periods> periodsList = new ArrayList<Periods>();
	
	public static ArrayList<Periods> getPeriodsList() {
		return periodsList;
	}

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPeriodName() {
		return periodName;
	}

	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}

	public String getPeriodTime() {
		return periodTime;
	}

	public void setPeriodTime(String periodTime) {
		this.periodTime = periodTime;
	}

	public Periods getPeriodPredecessor() {
		return periodPredecessor;
	}

	public void setPeriodPredecessor(Periods periodPredecessor) {
		this.periodPredecessor = periodPredecessor;
	}

	public Periods getPeriodSuccessor() {
		return periodSuccessor;
	}

	public void setPeriodSuccessor(Periods periodSuccessor) {
		this.periodSuccessor = periodSuccessor;
	}

	public String getPeriodCapital() {
		return periodCapital;
	}

	public void setPeriodCapital(String periodCapital) {
		this.periodCapital = periodCapital;
	}

	public Characters getPeriodFirstEmperor() {
		return periodFirstEmperor;
	}

	public void setPeriodFirstEmperor(Characters periodFirstEmperor) {
		this.periodFirstEmperor = periodFirstEmperor;
	}

	public Characters getPeriodLastEmperor() {
		return periodLastEmperor;
	}

	public void setPeriodLastEmperor(Characters periodLastEmperor) {
		this.periodLastEmperor = periodLastEmperor;
	}

	public String getPeriodReligion() {
		return periodReligion;
	}

	public void setPeriodReligion(String periodReligion) {
		this.periodReligion = periodReligion;
	}

	public void addPeriod(Periods c) {
        c.setId(periodsList.size());
        periodsList.add(c);
    }
    
	/*
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
            	
            	String name = (String) jcharacter.get("name");
            	String period = (String) jcharacter.get("period");
            	String born = (String) jcharacter.get("bornYear");
            	
            	Characters ch = new Characters();
            	
            	ch.setName(name);
            	ch.setPeriod(period);
            	ch.setBornYear(born);
            	
            	ch.addCharacter(ch);
            }
            
            JSONObject periodObject = (JSONObject) obj;
            JSONArray periodArray = (JSONArray)periodObject.get("period");
            
            for(int i=0 ; i<periodArray.size() ; i++) {
            	JSONObject jperiod = (JSONObject)periodArray.get(i);
            	
            	String periodName = (String) jperiod.get("PeriodName");
            	String capital = (String) jperiod.get("Capital");
            	String firstEmperor = (String) jperiod.get("FirstEmperor");
            	
            	Periods pr = new Periods();
            	
            	pr.setPeriodName(periodName);
            	pr.setCapital(capital);
            	pr.setFirstEmperor(matchingName(firstEmperor));
            		
            	pr.addPeriod(pr);
            }

            
            //display();
            for (int i=0; i<Characters.getCharactersList().size();i++) {
            	System.out.println(Characters.charactersList.get(i).getName());
            }
            //System.out.printf("index %d\n",matchingName("Đinh Liễn"));
            //System.out.println(Characters.charactersList.get(4).getName().contains("Dương ") );
           
    		
            System.out.println("------- (example) Character List -------");
            for (Periods i : periodsList){
            	System.out.printf("%-20s %-20s %-15s \n", i.getPeriodName(), i.getCapital(), i.getFirstEmperor().getBornYear());
            }
    }
    */
}
