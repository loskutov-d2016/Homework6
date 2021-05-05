import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class weather {
    private static Document getPage() throws IOException {
        String url = "http://www.pogoda.spb.ru/";
        Document page = Jsoup.parse(new URL(url), 20000);
        return page;
    }
    //чтобы из 05.05 Среда погода сегодняТемпература сделать
    // 05.05 нужно паттен ( \d{2}\.\d{2} )
    private static Pattern pattern = Pattern.compile("\\d{2}\\.\\d{2}");

    private static String getDateFromString(String stringDate) throws Exception {
        Matcher matcher = pattern.matcher(stringDate);
        if (matcher.find()){
            return matcher.group();
        }
        throw  new Exception("Cant extract date from string!");
    }

    private static boolean printPartValues(Elements values, int index) {
        if (index == 0) {
            Element valueLn = values.get(3);
            boolean isMorning = valueLn.text().contains("утро");
            int iterationCount = 4;
            if (isMorning) {
                iterationCount = 3;
            }
            for (int i = 0; i < iterationCount; i++) {
                Element valueLine = values.get(index + i);
//            valueLine = values.get(index);
                for (Element td : valueLine.select("td")) {
                    System.out.print(td.text() + "    ");
                }
                System.out.println();
            }

        } else {

        }
        return false;
    }

    public static void  main(String[] args) throws Exception {
        Document page = getPage();
        Element tableWth = page.select("table[class=wt]").first();
        Elements names = tableWth.select("tr[class=wth]");
        Elements values = tableWth.select("tr[valign=top]");
        int index = 0;

        for (Element name : names){
            String dataString = name.select("th[id=dt]").text();
            String date = getDateFromString(dataString);
            System.out.println(date +  " Явление Температура Давл Влажность Ветер");
            printPartValues(values, index);
        }
    }

}
