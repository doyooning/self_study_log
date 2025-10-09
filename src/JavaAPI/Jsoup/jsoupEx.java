package JavaAPI.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class jsoupEx {
    public static void main(String[] args) {
        // NOL티켓으로 변경~
        String url = "http://ticket.interpark.com/TPGoodsList.asp?Ca=Liv";
        String rtnUrl = "http://ticket.interpark.com";
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Elements performances = doc.select("div.Rk_gen2");
        String title1 = performances.select("caption").text();
        System.out.println(title1);

        int count = 1;
        for (Element perf : performances.select("tr")) {
            System.out.println(count + ". " + perf.select("td > span > a").text());
            String perfPlace = perf.select("td.Rkdate > a").text();
            System.out.println("장소 : " + perfPlace);
            System.out.println("기간 : " +  perf.select("td.Rkdate").text().substring(perfPlace.length()));
            System.out.println("예매링크 : " + rtnUrl + perf.select("td > span > a").attr("href"));
            count++;
        }



    }
}
