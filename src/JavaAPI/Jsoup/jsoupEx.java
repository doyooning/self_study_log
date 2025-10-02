package JavaAPI.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class jsoupEx {
    public static void main(String[] args) {
        // NOL티켓으로 변경~
        String url = "http://ticket.interpark.com/TPGoodsList.asp?Ca=Liv";
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Elements performances = doc.select("div.Rk_gen2");
        String title1 = performances.select("caption").text();
        System.out.println(title1);

        for (Element perf : performances.select("tr")) {
            System.out.println(perf.select("td > span > a").text());
        }

    }
}
