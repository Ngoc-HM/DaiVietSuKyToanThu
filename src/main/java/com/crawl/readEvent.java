package com.crawl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.stream.JsonWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class readEvent {
   public static void main(String[] args) throws IOException {
      String url = "https://thuvienlichsu.com/su-kien?page=";
      List<String> urls = new ArrayList<>();
      Document doc = null;
      for (int i = 0; i < 20; i++) {
         System.out.println(url + i);
         doc = Jsoup.connect(url + i).get();
         Elements events = doc.select("a[href*=/su-kien/]");
         for (Element event : events) {
            if (!urls.contains(event.absUrl("href"))) {
               urls.add(event.absUrl("href"));
            }
         }
      }
      OutputStream out = new FileOutputStream("src\\main\\resources\\json\\SuKien.json");
      JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
      writer.beginArray();
      for (String string : urls) {
         System.out.println(string);
         writer.beginObject();
         try {
            doc = Jsoup.connect(string).get();
         } catch (SocketTimeoutException e) {
            System.out.println(string + " --> fail");
         }
         Element eventName = doc.selectFirst("div.divide-line > h3");
         writer.name("name").value(eventName.text());

         // Event content
         Element eventContent = doc.select("div.card-body").get(1);
         writer.name("content").value(eventContent.text());

         // Event location
         Elements relatedLocations = doc.select("h3.card-title");
         writer.name("location");
         writer.beginArray();
         for (Element e1 : relatedLocations)
            writer.value(e1.text());
         writer.endArray();

         // Event people
         Elements relatedPeople = doc.select("h4.card-title");
         writer.name("people");
         writer.beginArray();
         for (Element e2 : relatedPeople)
            writer.value(e2.text());
         writer.endArray();

         writer.endObject();

      }
      writer.endArray();
      writer.close();
   }
}
