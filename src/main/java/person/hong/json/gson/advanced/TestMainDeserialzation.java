package person.hong.json.gson.advanced;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

/**
 * 测试类 测试自己实现反序列化接口
 *
 * @author 洪晓鸿
 * @version V1.0
 * @date 2019年4月27日 下午4:11:38
 */
public class TestMainDeserialzation {

    /**
     * main方法
     *
     * @param args
     */
    public static void main(String[] args) {
        // 创建一个builder对象 用于创建gson对象
        GsonBuilder builder = new GsonBuilder();
        // 创建gson对象
        Gson gson = builder.create();

        Reader reader;
        try {
            // 反序列化
            reader = new InputStreamReader(TestMainBook.class.getResourceAsStream("/sample.json"), "UTF-8");
            Book book = gson.fromJson(reader, Book.class);
            System.out.println(book);
            reader = new InputStreamReader(TestMainBook.class.getResourceAsStream("/alternativeName.json"), "UTF-8");
            book = gson.fromJson(reader, Book.class);
            System.out.println(book);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
/* 结果是:~
* 
* Book [authors=[Joshua Bloch, Neal Gafter], isbn10=032133678X, isbn13=978-0321336781, title=Java Puzzlers: Traps, Pitfalls, and Corner Cases]
Book [authors=[Joshua Bloch, Neal Gafter], isbn10=032133678X, isbn13=978-0321336781, title=Java Puzzlers: Traps, Pitfalls, and Corner Cases]

* 不使用自定义序列化的接口
* 也可以反序列化成功
* 使用注解的属性alternative属性可以接受更多属性名
* 相对应的值会被设置到对应的属性中
* 
*///:~