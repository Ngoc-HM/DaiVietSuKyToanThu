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

public class readCharacter {
   public static void main(String[] args) throws IOException {
      // Page 0 --> 119: 2391 characters
      String url = "https://vansu.vn/viet-nam/viet-nam-nhan-vat?page=";
      List<String> links = new ArrayList<>(), periods = new ArrayList<>(), locations = new ArrayList<>();
      Document document;
      int i = 0;
      for (; i < 120; i++) {
         document = Jsoup.connect(url + i).get();
         Element table = document.select("table").get(0); // select the first table.
         Elements rows = table.select("tr");
         for (int j = 1; j < rows.size() - 1; j++) {
            Element row = rows.get(j); // select each row in the table
            Elements cols = row.select("td");
            locations.add(cols.select("td").get(2).text());
            periods.add(cols.select("td").get(1).text());
            links.add(cols.select("a[href]").attr("abs:href"));
         }
      }
      OutputStream out = new FileOutputStream("src\\main\\resources\\json\\Character.json");
      JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
      writer.beginArray();
      i = 0;
      for (String link : links) {
         writer.beginObject();

         document = Jsoup.connect(link).get();
         Element name = document.selectFirst("div.active.section");
         writer.name("name").value(name.text());
         writer.name("location").value(locations.get(i));
         writer.name("period").value(periods.get(i));

         Elements tds = document.select("td");
         for (Element td : tds)
            if (td.attr("colspan").equals("2")) {
               writer.name("description").value(td.text());
               break;
            }

         String time = "";
         String[] year = { "Không rõ", "Không rõ" };
         Elements trs = document.select("tr");
         for (Element tr : trs) {
            if (tr.selectFirst("td").text().equals("Năm sinh")) {
               time = tr.select("td").get(1).text();
               int mid = time.indexOf("-");
               if (time.contains("...") || time.contains("…")) {
                  int unknown_1 = time.indexOf("..."), unknown_2 = time.indexOf("…"),
                        unknown = (unknown_1 != -1) ? unknown_1 : unknown_2;
                  if (unknown_1 != -1)
                     unknown = unknown_1;
                  else
                     unknown = unknown_2;
                  if (unknown < mid)
                     year[1] = time.substring(mid + 1).trim();
                  else
                     year[0] = time.substring(0, mid).trim();
               } else {
                  year[0] = time.substring(0, mid).equals("") ? "Không rõ" : time.substring(0, mid).trim();
                  year[1] = time.substring(mid + 1).equals("") ? "Không rõ" : time.substring(mid + 1).trim();
               }
               break;
            }
         }
         writer.name("bornYear").value(year[0]);
         writer.name("diedYear").value(year[1]);
         writer.endObject();
         i++;
      }
      writer.endArray();
      writer.close();
      out.close();
   }
}
