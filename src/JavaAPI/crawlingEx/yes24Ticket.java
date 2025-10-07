package JavaAPI.crawlingEx;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class yes24Ticket {
    public static void main(String[] args) {
        //
        String url = "https://ticket.yes24.com/New/Genre/GenreList.aspx?genretype=1&genre=15456";
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Elements performances = doc.select("section > div.ms-list-imgs");
        System.out.println("YES24 콘서트 정보");

        for (Element perf : performances.select("a")) {
            System.out.println(perf.select("div > div > p.list-b-tit1 v2").text());
        }

    }
}
