package JavaAPI.json;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class jsonFileLoadEx {
    public static void main(String[] args) {
        String src = "jsonEx.json";
        // 해당 클래스가 만들어진 곳에서 src와 연결, 연결 객체를 스트림으로 넘겨줌
        InputStream is = jsonFileLoadEx.class.getResourceAsStream(src);
        if(is == null) {
            throw new NullPointerException("Can't find resource " + src);
        }

        // 스트림 is는 문자열 데이터를 받은 것이라서,
        // 받은 문자열 데이터를 JSON 형태로 토큰화

        // 토큰화 객체 선언
        JSONTokener tokener = new JSONTokener(is);
        // object로 다시 JSON 객체로 만들어줌
        JSONObject object = new JSONObject(tokener);
        // object 안에 있던 배열 가져옴
        JSONArray jsonArray = object.getJSONArray("jsonArray");
        // 반복문으로 배열 돌면서 배열 안의 JSON 객체의 value 출력
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            System.out.print(jsonObject.get("name") + "\t");
            System.out.print(jsonObject.get("phone") + "\t");
            System.out.println(jsonObject.get("address"));
        }


    }
}
