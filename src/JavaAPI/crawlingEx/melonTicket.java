package JavaAPI.crawlingEx;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class melonTicket {
    public static void main(String[] args) {
        String url = "https://ticket.melon.com/performance/ajax/prodList.json?commCode=&sortType=HIT&perfGenreCode=GENRE_CON_ALL&perfThemeCode=&filterCode=FILTER_ALL&v=1";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent", "Mozilla/5.0")
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            JSONObject json = new JSONObject(responseBody);
            JSONArray list = json.getJSONArray("data");

            System.out.println("=== 멜론 티켓 인기 공연 목록 ===\n");

            for (int i = 0; i < list.length(); i++) {
                JSONObject item = list.getJSONObject(i);
                String title = item.optString("title", "제목 없음");
                String place = item.optString("placeName", "장소 미정");
                String period = item.optString("periodInfo", "기간 미정");
                String region = item.optString("regionName", "-");

                System.out.println((i + 1) + ". " + title);
                System.out.println("장소: " + place + ", " + region);
                System.out.println("기간: " + period);
                System.out.println();
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
