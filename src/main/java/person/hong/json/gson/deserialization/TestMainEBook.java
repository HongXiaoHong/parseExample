package person.hong.json.gson.deserialization;

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
                .registerTypeAdapter(Book.class, new BookDeserializer());
        // 创建gson对象
        Gson gson = builder.create();

        Reader reader;
        try {
            reader = new InputStreamReader(TestMainEBook.class.getResourceAsStream("/complicated.json"), "UTF-8");
            EBook book = gson.fromJson(reader, EBook.class);
            System.out.println(book);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 反序列化
    }

}
/* 结果是:~
 *
 * EBook [authors=[Author [id=1, name=Joshua Bloch], Author [id=2, name=Neal Gafter]], isbn=032133678X, title=Java Puzzlers: Traps, Pitfalls, and Corner Cases]

 * 成功解析
 * 要注意的主要是要对应好类型
 *///:~