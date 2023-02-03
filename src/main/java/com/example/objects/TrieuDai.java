package com.example.objects;

public class TrieuDai {
   private String time;
   private String kingdomName;
   private String kingName;
   private String year;
   private String age;

   public TrieuDai(String thoiKy, String tenTrieuDai, String vua, String namTriVi, String tuoiTho) {
      this.time = thoiKy;
      this.kingdomName = tenTrieuDai;
      this.kingName = vua;
      this.year = namTriVi;
      this.age = tuoiTho;
   }

   public String getTime() {
      return time;
   }

   public void setTime(String time) {
      this.time = time;
   }

   public String getKingdomName() {
      return kingdomName;
   }

   public void setKingdomName(String kingdomName) {
      this.kingdomName = kingdomName;
   }

   public String getKingName() {
      return kingName;
   }

   public void setKingName(String kingName) {
      this.kingName = kingName;
   }

   public String getYear() {
      return year;
   }

   public void setYear(String year) {
      this.year = year;
   }

   public String getAge() {
      return age;
   }

   public void setAge(String age) {
      this.age = age;
   }

   @Override
   public String toString() {
      return this.time + " - " + this.kingdomName + " - " + this.kingName + " - " + this.year + " - " + this.age;
   }
}
