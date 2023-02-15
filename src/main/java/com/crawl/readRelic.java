package com.crawl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.stream.JsonWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class readRelic {
   public static void main(String[] args) throws IOException {
      List<String> relic = new ArrayList<>();
      String url = "https://thuvienlichsu.com/dia-diem?page=";
      Document doc;
      Elements elements;
      for (int i = 0; i <= 10; i++) {
         doc = Jsoup.connect(url + i).get();
         elements = doc.select("a[href*=/dia-diem/]");
         for (Element element : elements) {
            String tmp = element.absUrl("href");
            if (!tmp.contains("page") && !relic.contains(tmp))
               relic.add(tmp);
         }
      }
      OutputStream out = new FileOutputStream("src\\main\\resources\\json\\Relic.json");
      JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
      writer.beginArray();
      for (String r : relic) {
         writer.beginObject();
         System.out.println(r);
         doc = Jsoup.connect(r).get();
         Element RelicName = doc.selectFirst("div.divide-line > h3");
         writer.name("RelicName").value(RelicName.text());
         Element RelicDescription = doc.select("div.card-body").get(1);
         writer.name("RelicDescription").value(RelicDescription.text());
         Elements RelatedEvent = doc.select("h4.card-title");
         writer.name("RelatedEvent");
         writer.beginArray();
         for (Element e : RelatedEvent) {
            writer.value(e.text());
         }
         writer.endArray();
         writer.endObject();
      }
      writer.endArray();
      writer.close();
      out.close();
   }
}
