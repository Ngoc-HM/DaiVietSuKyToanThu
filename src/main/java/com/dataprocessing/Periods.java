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
	String PeriodName;
	String PeriodTime;
	Periods PeriodPredecessor;
	Periods PeriodSuccessor;
	String Capital;
    Characters FirstEmperor;
    Characters LastEmperor;
    String Religion;
	
	public static ArrayList<Periods> periodsList = new ArrayList<Periods>();

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPeriodName() {
		return PeriodName;
	}

	public void setPeriodName(String periodName) {
		PeriodName = periodName;
	}

	public String getPeriodTime() {
		return PeriodTime;
	}

	public void setPeriodTime(String periodTime) {
		PeriodTime = periodTime;
	}

	public Periods getPeriodPredecessor() {
		return PeriodPredecessor;
	}

	public void setPeriodPredecessor(Periods periodPredecessor) {
		PeriodPredecessor = periodPredecessor;
	}

	public Periods getPeriodSuccessor() {
		return PeriodSuccessor;
	}

	public void setPeriodSuccessor(Periods periodSuccessor) {
		PeriodSuccessor = periodSuccessor;
	}

	public String getCapital() {
		return Capital;
	}

	public void setCapital(String capital) {
		Capital = capital;
	}

	public Characters getFirstEmperor() {
		return FirstEmperor;
	}

	public static Characters matchingName(String name){
		Characters wanted = null;
		for (Characters ch : Characters.charactersList) {
            if (ch.getName().contains(name)){
            	wanted = ch;
            	break;
            }
        }
        return wanted;
    }
	
	/*
	public void setFirstEmperor(String firstEmperorName) {
		//FirstEmperor = firstEmperor;
		int i = matchingName(firstEmperorName);

		FirstEmperor.setName(Characters.charactersList.get(i).getName());
		FirstEmperor.setPeriod(Characters.charactersList.get(i).getPeriod());
		FirstEmperor.setBornYear(Characters.charactersList.get(i).getBornYear());
	}
	*/
	
	public void setFirstEmperor(Characters firstEmperor) {
		FirstEmperor = firstEmperor;
	}

	public Characters getLastEmperor() {
		return LastEmperor;
	}

	public void setLastEmperor(Characters lastEmperor) {
		LastEmperor = lastEmperor;
	}

	public String getReligion() {
		return Religion;
	}

	public void setReligion(String religion) {
		Religion = religion;
	}

	public void addPeriod(Periods c) {
        c.setId(periodsList.size());
        periodsList.add(c);
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
            	System.out.println(Characters.getCharactersList().get(i).getName());
            }
            //System.out.printf("index %d\n",matchingName("Đinh Liễn"));
            //System.out.println(Characters.charactersList.get(4).getName().contains("Đinh Liễn") );
           
    		
            System.out.println("------- (example) Character List -------");
            for (Periods i : periodsList){
            	System.out.printf("%-20s %-20s %-15s \n", i.getPeriodName(), i.getCapital(), i.getFirstEmperor().getName());
            }
    }
}
