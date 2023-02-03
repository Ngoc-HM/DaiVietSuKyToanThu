package com.example.objects;

public class Character {
   private String name;
   private String location;
   private String period;
   private String description;
   private String bornYear;
   private String diedYear;

   public Character(String name, String location, String period, String description, String bornYear, String diedYear) {
      this.name = name;
      this.location = location;
      this.period = period;
      this.description = description;
      this.bornYear = bornYear;
      this.diedYear = diedYear;
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

}
