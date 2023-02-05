package com.example.objects;

public class Character {
   private String charactername;
   private String characterlocation;
   private String characterperiod;
   private String characterdescription;
   private String characterbornYear;
   private String characterdiedYear;

   public Character(String name, String location, String period, String description, String bornYear, String diedYear) {
      this.charactername = name;
      this.characterlocation = location;
      this.characterperiod = period;
      this.characterdescription = description;
      this.characterbornYear = bornYear;
      this.characterdiedYear = diedYear;
   }

   public String getName() {
      return charactername;
   }

   public void setName(String name) {
      this.charactername = name;
   }

   public String getLocation() {
      return characterlocation;
   }

   public void setLocation(String location) {
      this.characterlocation = location;
   }

   public String getPeriod() {
      return characterperiod;
   }

   public void setPeriod(String period) {
      this.characterperiod = period;
   }

   public String getDescription() {
      return characterdescription;
   }

   public void setDescription(String description) {
      this.characterdescription = description;
   }

   public String getBornYear() {
      return characterbornYear;
   }

   public void setBornYear(String bornYear) {
      this.characterbornYear = bornYear;
   }

   public String getDiedYear() {
      return characterdiedYear;
   }

   public void setDiedYear(String diedYear) {
      this.characterdiedYear = diedYear;
   }

}
