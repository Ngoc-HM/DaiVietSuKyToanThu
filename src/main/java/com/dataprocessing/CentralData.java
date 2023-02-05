package com.dataprocessing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CentralData implements Serializable{
	
	public static ArrayList<Characters> charactersList = new ArrayList<Characters>();
	public static ArrayList<Periods> periodsList = new ArrayList<Periods>();
	public static ArrayList<Events> eventsList = new ArrayList<Events>();
		public static ArrayList<Characters> eventsPeopleList = new ArrayList<Characters>();
		public static ArrayList<Relics> eventsLocationList = new ArrayList<Relics>();
	public static ArrayList<Relics> relicsList = new ArrayList<Relics>();
		public static ArrayList<Events> relicsEventList = new ArrayList<Events>();
	public static ArrayList<Festivals> festivalsList = new ArrayList<Festivals>();

	public static Characters matchingCharacterName(String name){
		Characters wanted = null;
		for (Characters ch : Characters.charactersList) {
            if (ch.getCharacterName().contains(name)){
            	wanted = ch;
            	break;
            }
        }
        return wanted;
    }
	
	public static Periods matchingPeriodName(String name){
		Periods wanted = null;
		for (Periods ch : Periods.periodsList) {
            if (ch.getPeriodName().contains(name)){
            	wanted = ch;
            	break;
            }
        }
        return wanted;
    }
	
	public static Relics matchingLocationName(String name){
		Relics wanted = null;
		for (Relics ev : Relics.relicsList) {
            if (ev.getRelicName().contains(name)){
            	wanted = ev;
            	break;
            }
        }
        return wanted;
    }
	
	public static Events matchingEventName(String name){
		Events wanted = null;
		for (Events ev : Events.eventsList) {
            if (ev.getEventName().contains(name)){
            	wanted = ev;
            	break;
            }
        }
        return wanted;
    }
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        FileReader reader = new FileReader("//resources//json//CentralData.json");
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            
            
            //------------- Read Characters' Data -------------
            JSONObject characterObject = (JSONObject) obj;
            
            JSONArray characterArray = (JSONArray)characterObject.get("character");
            
            for(int i=0 ; i<characterArray.size() ; i++) {
            	JSONObject jcharacter = (JSONObject)characterArray.get(i);
            	
            	String name = (String) jcharacter.get("name");
            	String location = (String) jcharacter.get("location");
            	String period = (String) jcharacter.get("period");
            	String description = (String) jcharacter.get("description");
            	String born = (String) jcharacter.get("bornYear");
            	String died = (String) jcharacter.get("diedYear");
            	
            	Characters ch = new Characters();
            	
            	ch.setCharacterName(name);
            	ch.setCharacterLocation(location);
            	ch.setCharacterPeriod(period);
            	ch.setCharacterDescription(description);
            	ch.setCharacterBornYear(born);
            	ch.setCharacterDiedYear(died);
            	
            	ch.addCharacter(ch);
            }
            
            
            //------------- Read Periods' Data -------------
            JSONObject periodObject = (JSONObject) obj;
            JSONArray periodArray = (JSONArray)periodObject.get("period");
            
            for(int i=0 ; i<periodArray.size() ; i++) {
            	JSONObject jperiod = (JSONObject)periodArray.get(i);
            	
            	String periodName = (String) jperiod.get("PeriodName");
            	String periodTime = (String) jperiod.get("PeriodTime");
            	String periodPredecessor = (String) jperiod.get("PeriodPredecessor");
            	String periodSuccessor = (String) jperiod.get("PeriodSuccessor");
            	String capital = (String) jperiod.get("Capital");
            	String firstEmperor = (String) jperiod.get("FirstEmperor");
            	String lastEmperor = (String) jperiod.get("LastEmperor");
            	String religion = (String) jperiod.get("Religion");
            	
            	Periods pr = new Periods();
            	
            	pr.setPeriodName(periodName);
            	pr.setPeriodTime(periodTime);
            	pr.setPeriodPredecessor(matchingPeriodName(periodPredecessor));
            	pr.setPeriodSuccessor(matchingPeriodName(periodSuccessor));
            	pr.setPeriodCapital(capital);
            	pr.setPeriodFirstEmperor(matchingCharacterName(firstEmperor));
            	pr.setPeriodLastEmperor(matchingCharacterName(lastEmperor));
            	pr.setPeriodReligion(religion);
            	
            	pr.addPeriod(pr);
            }
            
          //------------- Read Events' Data -------------
            JSONObject eventObject = (JSONObject) obj;
            JSONArray eventArray = (JSONArray)eventObject.get("event");
            
            for(int i=0 ; i<eventArray.size() ; i++) {
            	JSONObject jevent = (JSONObject)eventArray.get(i);
            	Events ev = new Events();
            	
            	String eventName = (String) jevent.get("name");
            	String eventContent = (String) jevent.get("content");
            	JSONArray eventLocationArray = (JSONArray) jevent.get("location");
            	for(int j=0 ; j<eventLocationArray.size() ; j++) {
            		eventsLocationList.add(matchingLocationName(eventLocationArray.get(j).toString()));
            	}
            	JSONArray eventPeopleArray = (JSONArray)jevent.get("people");
            	for(int j=0 ; j<eventPeopleArray.size() ; j++) {
            		eventsPeopleList.add(matchingCharacterName(eventPeopleArray.get(j).toString()));
            	}
            	
            	ev.setEventName(eventName);
            	ev.setEventContent(eventContent);
            	ev.setEventLocation(eventsLocationList);
            	ev.setEventPeople(eventsPeopleList);
            	
            	ev.addEvents(ev);

            	for (Events in : eventsList){
                	System.out.printf("%-20s %-20s \n", in.getEventName(), in.getEventPeople());
                }
            }

            //------------- Read Relics' Data -------------
            JSONObject relicObject = (JSONObject) obj;
            JSONArray relicArray = (JSONArray)relicObject.get("relic");
            
            for(int i=0 ; i<relicArray.size() ; i++) {
            	JSONObject jrelic = (JSONObject)relicArray.get(i);
            	Relics re = new Relics();
            	
            	String relicName = (String) jrelic.get("name");
            	String relicDescription = (String) jrelic.get("RelicDescription");
            	JSONArray relicEventArray = (JSONArray) jrelic.get("RelatedEvent");
            	for(int j=0 ; j<relicEventArray.size() ; j++) {
            		relicsEventList.add(matchingEventName(relicEventArray.get(j).toString()));
            	}
            	
            	re.setRelicName(relicName);
            	re.setRelicDescription(relicDescription);
            	re.setRelicEvent(relicsEventList);
            	
            	re.addRelics(re);
            }

          //------------- Read Festivals' Data -------------
            JSONObject festivalObject = (JSONObject) obj;
            JSONArray festivalArray = (JSONArray)festivalObject.get("festival");
            
            for(int i=0 ; i<periodArray.size() ; i++) {
            	JSONObject jfestival = (JSONObject)festivalArray.get(i);
            	
            	String festivalLunarDate = (String) jfestival.get("lunarDate");
            	String festivalLocation = (String) jfestival.get("festivalLocation");
            	String festivalName = (String) jfestival.get("festivalName");
            	String festivalRelatedCharacter = (String) jfestival.get("relatedFigure");
            	
            	Festivals fe = new Festivals();
            	
            	fe.setFestivalLunarDate(festivalLunarDate);
            	fe.setFestivalLocation(festivalLocation);
            	fe.setFestivalName(festivalName);
            	fe.setFestivalRelatedCharacter(matchingCharacterName(festivalRelatedCharacter));
            	
            	fe.addFestivals(fe);
            }
    }

}
