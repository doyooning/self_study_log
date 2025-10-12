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
                int id = item.getInt("prodId");

                // 티켓오픈일 가져오기
                JSONObject saleTypeJson = new JSONObject(item.getString("saleTypeJson"));
                JSONObject dataJson = saleTypeJson.getJSONObject("data");
                JSONArray listArray = dataJson.getJSONArray("list");
                JSONObject listJson = listArray.getJSONObject(0);
                JSONArray saleTypeCodeList = listJson.getJSONArray("saleTypeCodeList");
                JSONObject saleTypeCodeListJson = saleTypeCodeList.getJSONObject(0);
                String reserveStartDt = saleTypeCodeListJson.optString("reserveStartDt", "-");

                String title = item.optString("title", "제목 없음");
                String place = item.optString("placeName", "장소 미정");
                String period = item.optString("periodInfo", "기간 미정");
                String region = item.optString("regionName", "-");

                System.out.println((i + 1) + ". " + title);
                System.out.println("장소: " + place + ", " + region);
                System.out.println("기간: " + period);
                System.out.println("공연id: " + id);
                System.out.println("예매 오픈: " + reserveStartDt);
                // reserveStartDt -> 20251010200000
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
