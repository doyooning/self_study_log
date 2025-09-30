package JavaAPI.json;

import org.json.JSONArray;
import org.json.JSONObject;

public class jsonEx {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "홍길동");
        jsonObject.put("phone", "010-1111-2222");
        jsonObject.put("address", "서울");
        System.out.println(jsonObject);

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name", "고길동");
        jsonObject1.put("phone", "010-4444-4444");
        jsonObject1.put("address", "인천");

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonObject);
        jsonArray.put(jsonObject1);
        System.out.println(jsonArray);

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("objects", jsonArray);

        System.out.println(jsonObject2.toString(2));
    }
}
