package com.dataprocessing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CentralData {

	public static int matchingName(String name){
		int num = 0;
        for (Characters ch : Characters.charactersList){
            if(ch.getName() != "" && ch.getName().equals(name)){
            	num = ch.getId();
            }
            else num = 7;
        }
        return num;
    }
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        FileReader reader = new FileReader("D:\\Resources\\SampleDataBase.json");
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject periodObject = (JSONObject) obj;
            
            JSONArray periodArray = (JSONArray)periodObject.get("period");
            
            for(int i=0 ; i<periodArray.size() ; i++) {
            	JSONObject jperiod = (JSONObject)periodArray.get(i);
	
            	Periods pr = new Periods();
            	
            	pr.setPeriodName((String) jperiod.get("PeriodName"));
            	pr.setCapital((String) jperiod.get("capital"));
            	pr.setFirstEmperor((String) jperiod.get("FirstEmperor"));
            	
            	pr.addPeriod(pr);
            }
            
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
            //for (int i=0; i<Characters.getCharactersList().size();i++) {
            //	System.out.println(Characters.getCharactersList().get(i).getName());
            //}
            System.out.printf("index %d",matchingName("Đinh Liễn"));
            //System.out.println("------- (example) Character List -------");
            //for (Periods i : periodsList){
            //	System.out.printf("%20s %-20s %-15s \n", i.getPeriodName(), i.getCapital(), i.getFirstEmperor().getName());
            //}
    }

}
