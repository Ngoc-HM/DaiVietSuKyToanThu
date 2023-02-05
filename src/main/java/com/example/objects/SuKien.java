package com.example.objects;

public class SuKien {
   private String eventname, eventcontent;
   private String[] eventlocation, eventpeople;

   public SuKien(String name, String content, String[] location, String[] people) {
      this.eventname = name;
      this.eventcontent = content;
      this.eventlocation = location;
      this.eventpeople = people;
   }

   public String getName() {
      return eventname;
   }

   public void setName(String name) {
      this.eventname = name;
   }

   public String getContent() {
      return eventcontent;
   }

   public void setContent(String content) {
      this.eventcontent = content;
   }

   public String[] getLocation() {
      return eventlocation;
   }

   public void setLocation(String[] location) {
      this.eventlocation = location;
   }

   public String[] getPeople() {
      return eventpeople;
   }

   public void setPeople(String[] people) {
      this.eventpeople = people;
   }
}
