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

public class readPeriod {

   public static void main(String[] args) throws IOException {
      String url = "https://vi.wikipedia.org/wiki/L%E1%BB%8Bch_s%E1%BB%AD_Vi%E1%BB%87t_Nam";
      Document document = Jsoup.connect(url).get();
      Element table = document.selectFirst("table.toccolours");
      Elements rows = table.select("tr");
      List<String> periods = new ArrayList<>();
      for (int i = 2; i < rows.size() - 4; i++) {
         Elements tmp = rows.get(i).select("a[href]");
         if (tmp != null)
            for (Element t : tmp) {
               String periodURL = t.absUrl("href");
               Element font = rows.get(i).selectFirst("font");
               if (!periods.contains(periodURL))
                  if (!t.text().contains("–") && font != null)
                     periods.add(periodURL);
            }
      }
      OutputStream out = new FileOutputStream("src\\main\\resources\\json\\Period.json");
      JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
      writer.beginArray();
      int tmpLength = 3;
      for (int i = 0; i < periods.size() - 1; i++) {
         int result = 0;
         String[] obj = new String[8];
         document = Jsoup.connect(periods.get(i)).get();
         String name = document.selectFirst("span.mw-page-title-main").text();
         Elements texts = document.select("table.infobox > tbody > tr > td");
         if (texts.size() > tmpLength) {
            String time = "";
            if (texts.get(0).text().contains("–") || texts.get(0).text().contains("-"))
               time = texts.get(0).text();
            else if (texts.get(1).text().contains("–") || texts.get(1).text().contains("-"))
               time = texts.get(1).text();
            else if (texts.get(3).text().contains("–") || texts.get(3).text().contains("-"))
               time = texts.get(3).text();
            else if (texts.get(2).text().contains("–") || texts.get(2).text().contains("-"))
               time = texts.get(2).text();
            if (!time.equals("")) {
               obj[0] = name;
               obj[1] = time.replace("← ", "").replace("→", "");
               result += 2;
            }
         }
         Elements tables = document.select("table");
         String PeriodPredecessor = "", PeriodSuccessor = "";
         for (Element t : tables) {
            if (t.attr("style").equals(
                  "width:95%; background: transparent; text-align:center; margin:0 auto; display:inline-table;")) {
               Elements cells = t.select("tr").get(1).select("a[href]");
               PeriodPredecessor = cells.get(0).text();
               PeriodSuccessor = cells.get(1).text();
               obj[2] = PeriodPredecessor;
               obj[3] = PeriodSuccessor;
               result += 2;
               break;
            }
         }
         String capital = "";
         rows = document.select("table.infobox > tbody > tr");
         for (Element row : rows) {
            Element tmp = row.selectFirst("a[href]");
            if (tmp != null) {
               if (tmp.attr("title").equals("Thủ đô")) {
                  capital = row.selectFirst("td").text();
                  obj[4] = capital;
                  result++;
                  break;
               }
            }
         }
         List<String> kings = new ArrayList<>();
         Elements kingRows = document.select("tr.mergedrow");
         for (int j = 2; j < kingRows.size(); j++) {
            if (kingRows.get(j).text().equals(""))
               break;
            else {
               kings.add(kingRows.get(j).text().replace("• ", ""));
            }
         }

         if (kings.size() != 0) {
            obj[5] = kings.get(0);
            obj[6] = kings.get(kings.size() - 1);
            result += 2;
         }
         String religion = "";
         rows = document.select("table.infobox > tbody > tr");
         for (Element row : rows) {
            Element tmp = row.selectFirst("a[href]");
            if (tmp != null) {
               if (tmp.attr("title").equals("Tôn giáo")) {
                  religion = row.selectFirst("td").text();
                  obj[7] = religion;
                  result++;
                  break;
               }
            }
         }
         if (result > 3) {
            writer.beginObject();
            writer.name("PeriodName").value(obj[0]);
            writer.name("PeriodTime").value(obj[1]);
            writer.name("PeriodPredecessor").value(obj[2]);
            writer.name("PeriodSuccessor").value(obj[3]);
            writer.name("Capital").value(obj[4]);
            writer.name("FirstEmperor").value(obj[5]);
            writer.name("LastEmperor").value(obj[6]);
            writer.name("Religion").value((obj[7] == null) ? "" : obj[7]);
            writer.endObject();
         }
      }
      writer.endArray();
      writer.close();
      out.close();
   }
}
