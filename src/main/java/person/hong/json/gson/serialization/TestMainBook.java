package person.hong.json.gson.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 测试类 测试自己实现序列化接口
 * 对Book对象进行序列化
 *
 * @author 洪晓鸿
 * @version V1.0
 * @date 2019年4月27日 下午2:58:29
 */
public class TestMainBook {

    /**
     * main方法
     *
     * @param args
     */
    public static void main(String[] args) {
        // 创建一个builder对象 用于创建gson对象
        GsonBuilder builder = new GsonBuilder()
                //注册序列化器
                .registerTypeAdapter(Book.class, new BookSerialiser())
                //告诉了 Gson 对生成的 JSON 对象进行格式化 也就是json工具中的美化
                .setPrettyPrinting();
        // 创建gson对象
        Gson gson = builder.create();

        // 创建book
        final Book book = new Book();
        book.setTitle("Java 编程思想");
        book.setIsbn10("isbn10-032133678X");
        book.setIsbn13("978-7-111-21250-8");
        book.setAuthors(new String[]{"Bruce Eckel", "陈昊鹏"});

        // 序列化
        String result = gson.toJson(book);
        System.out.println(result);
    }

}
/* 结果是:~
* {
  "title": "Java 编程思想",
  "isbn-10": "isbn10-032133678X",
  "isbn-13": "978-7-111-21250-8",
  "authors": [
    "Bruce Eckel",
    "陈昊鹏"
  ]
}
*///:~