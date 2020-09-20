package person.hong.json.gson.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 测试类 测试自己实现序列化接口  对象中有对象 即复杂对象
 *
 * @author 洪晓鸿
 * @version V1.0
 * @date 2019年4月27日 下午3:16:36
 */
public class TestMainEBook {

    /**
     * main方法
     *
     * @param args
     */
    public static void main(String[] args) {
        // 创建一个builder对象 用于创建gson对象
        GsonBuilder builder = new GsonBuilder()
                //注册序列化器
                .registerTypeAdapter(EBook.class, new EBookSerialiser())
                //告诉了 Gson 对生成的 JSON 对象进行格式化
                .setPrettyPrinting();
        // 创建gson对象
        Gson gson = builder.create();

        // 创建book
        final EBook book = new EBook();
        book.setTitle("Java 编程思想");
        book.setIsbn("978-7-111-21250-8");
        book.setAuthors(new Author[]{new Author(1, "Bruce Eckel"), new Author(2, "陈昊鹏")});

        // 序列化
        String result = gson.toJson(book);
        System.out.println(result);
    }

}
/* 结果是:~
* {
  "title": "Java 编程思想",
  "isbn": "978-7-111-21250-8",
  "authors": [
    {
      "id": 1,
      "name": "Bruce Eckel"
    },
    {
      "id": 2,
      "name": "陈昊鹏"
    }
  ]
}
*///:~