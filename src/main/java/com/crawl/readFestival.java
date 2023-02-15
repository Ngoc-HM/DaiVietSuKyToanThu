package com.crawl;

import java.io.OutputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import com.google.gson.stream.JsonWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class readFestival {
   public static void main(String[] args) throws IOException {
      String url = "https://vi.wikipedia.org/wiki/L%E1%BB%85_h%E1%BB%99i_Vi%E1%BB%87t_Nam";
      Element table = Jsoup.connect(url).get().select("table").get(1);
      Elements rows = table.select("tr");
      OutputStream out = new FileOutputStream("src\\main\\resources\\json\\Festival_test.json");
      JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
      writer.beginArray();
      for (int i = 1; i < rows.size(); i++) {
         writer.beginObject();
         Element row = rows.get(i);
         Element date = row.select("td").get(0);
         writer.name("lunarDate").value((date.text().equals("")) ? "Không rõ" : date.text());

         Element place = row.select("td").get(1);
         writer.name("festivalLocation").value(place.text());

         Element name = row.select("td").get(2);
         writer.name("festivalName").value(name.text());

         Element relatedFigure = row.select("td").get(4);
         writer.name("relatedFigure").value(relatedFigure.text());
         writer.endObject();
      }
      writer.endArray();
      writer.close();
   }
}
