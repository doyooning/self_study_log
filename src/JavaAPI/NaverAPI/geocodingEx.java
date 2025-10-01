package JavaAPI.NaverAPI;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

public class geocodingEx {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String clientId = "vtlypwpkhj";
    static String clientSecret = "myKRj3N9rPMhqYJxOZbMBnQFBNsYNFTpZf4SpfAU";

    public static void main(String[] args) {
        // 주소 -> 위도, 경도 불러오기

        try {
            System.out.print("주소를 입력하세요: ");
            String address = br.readLine();
            String addr = URLEncoder.encode(address, "UTF-8"); // 입력 공백도 문자처리 해주기 위함
            String apiURL = "https://maps.apigw.ntruss.com/map-geocode/v2/geocode?query=" + addr; // json

            // 요청 전송을 위한 세팅
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET"); // 요청 방식 GET
            con.setRequestProperty("x-ncp-apigw-api-key-id",  clientId); // REQUIRED
            con.setRequestProperty("x-ncp-apigw-api-key",  clientSecret); // REQUIRED
            int responseCode = con.getResponseCode(); // 응답 코드 반환 (200 : 정상호출)
            if (responseCode == 200) {
                // 읽어들일 때 한글이면 UTF-8
                br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer sb = new StringBuffer();
            // inputLine으로 읽어들인 한 줄 한 줄을 sb로 append

            String x = "";
            String y = "";
            String z = "";
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            br.close();

            // sb를 JSON 객체로 변환
            JSONTokener tokener = new JSONTokener(sb.toString());
            JSONObject object = new JSONObject(tokener);
//            System.out.println(object);
            JSONArray arr = object.getJSONArray("addresses");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = (JSONObject) arr.get(i);
                System.out.println("address: " + obj.get("roadAddress"));
                System.out.println("jibunAddress: " + obj.get("jibunAddress"));
                System.out.println("경도: " + obj.get("x"));
                System.out.println("위도: " + obj.get("y"));
                x = (String) obj.get("x");
                y = (String) obj.get("y");
                z = (String) obj.get("roadAddress");
            }
            map_service(x, y, z);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void map_service(String point_x, String point_y, String address) {
        // URL
        String URL_STATICMAP = "https://maps.apigw.ntruss.com/map-static/v2/raster?";
        try {
            // 공백, 오타 주의 !!
            String pos = URLEncoder.encode(point_x + " " + point_y, "UTF-8");
            String url = URL_STATICMAP;
            // URL에 요소들 결합
            url += "center=" + point_x + "," + point_y;
            url += "&level=16&w=700&h=500";
            url += "&markers=type:t|size:mid|pos:" + pos + "|label:" + URLEncoder.encode(address, "UTF-8");
            URL u = new URL(url);
            HttpURLConnection con = (HttpURLConnection) u.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("x-ncp-apigw-api-key-id", clientId);
            con.setRequestProperty("x-ncp-apigw-api-key", clientSecret);
            int responseCode = con.getResponseCode();
            if (responseCode == 200) {
                // 사진은 InputStream -> FileOutputStream(바이트)
                InputStream is = con.getInputStream();
                int read = 0;
                byte[] bytes = new byte[1024];
                String tempname = Long.valueOf(new Date().getTime()).toString();
                File f = new File(tempname + ".jpg");
                f.createNewFile();
                OutputStream outputStream = new FileOutputStream(f);
                while ((read = is.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
                is.close();

            } else {
                br = new BufferedReader((new InputStreamReader(con.getErrorStream())));
                String inputLine;
                StringBuffer sb = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    sb.append(inputLine);
                }
                br.close();
                System.out.println(sb.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
