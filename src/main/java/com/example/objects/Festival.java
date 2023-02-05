package com.example.objects;

public class Festival {
   private String festivallunarDate;
   private String festivalLocation;
   private String festivalName;
   private String festivalrelatedFigure;
   
   public Festival(String lunarDate, String festivalLocation, String festivalName, String relatedFigure) {
      this.festivallunarDate = lunarDate;
      this.festivalLocation = festivalLocation;
      this.festivalName = festivalName;
      this.festivalrelatedFigure = relatedFigure;
   }
   public String getLunarDate() {
      return festivallunarDate;
   }
   public String getFestivalLocation() {
      return festivalLocation;
   }
   public String getFestivalName() {
      return festivalName;
   }
   public String getRelatedFigure() {
      return festivalrelatedFigure;
   }
   
}
