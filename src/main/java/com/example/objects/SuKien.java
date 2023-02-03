package com.example.objects;

public class SuKien {
   private String name, content;
   private String[] location, people;

   public SuKien(String name, String content, String[] location, String[] people) {
      this.name = name;
      this.content = content;
      this.location = location;
      this.people = people;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public String[] getLocation() {
      return location;
   }

   public void setLocation(String[] location) {
      this.location = location;
   }

   public String[] getPeople() {
      return people;
   }

   public void setPeople(String[] people) {
      this.people = people;
   }
}
