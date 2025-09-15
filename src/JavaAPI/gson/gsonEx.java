package JavaAPI.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class gsonEx {
    public static void main(String[] args) {
        bookdto dto = new bookdto("자바", "홍길동", 20000);

        // gson 객체 생성
        Gson gson = new Gson();

        // Object(bookdto) -> JSON(String)
        String json = gson.toJson(dto);
        System.out.println(json);

        // JSON(String) -> Object(bookdto)
        bookdto dto1 = gson.fromJson(json, bookdto.class);
        System.out.println(dto1);
        System.out.println(dto1.getBookName());

        // Object(List) -> JSON(String)
        List<bookdto> list = new ArrayList<>();
        list.add(new bookdto("java1", "author1", 10000));
        list.add(new bookdto("java2", "author2", 20000));
        list.add(new bookdto("java3", "author3", 30000));
        String listjson = gson.toJson(list);
        System.out.println(listjson);

        // JSON(String) -> Object(List)
        // List로 바꿀 때는 별도로 List 안에 들어갈 type의 정보를 알려주어야 함
        // Reflect -> TypeToken 사용
        gson.fromJson(listjson, new TypeToken<List<bookdto>>() {}.getType());
        for (bookdto vo : list) {
            System.out.println(vo.getBookName());
        }

    }
}
