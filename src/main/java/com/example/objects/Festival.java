package com.example.objects;

public class Festival {
   private String lunarDate;
   private String festivalLocation;
   private String festivalName;
   private String relatedFigure;
   
   public Festival(String lunarDate, String festivalLocation, String festivalName, String relatedFigure) {
      this.lunarDate = lunarDate;
      this.festivalLocation = festivalLocation;
      this.festivalName = festivalName;
      this.relatedFigure = relatedFigure;
   }
   public String getLunarDate() {
      return lunarDate;
   }
   public String getFestivalLocation() {
      return festivalLocation;
   }
   public String getFestivalName() {
      return festivalName;
   }
   public String getRelatedFigure() {
      return relatedFigure;
   }
   
}
