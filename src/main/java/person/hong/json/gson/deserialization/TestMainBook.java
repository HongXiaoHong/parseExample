package person.hong.json.gson.deserialization;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * 测试类 测试自己实现反序列化接口
 * @author 洪晓鸿     
 * @date   2019年4月27日 下午4:11:38   
 * @version V1.0
 */
public class TestMainBook {

	/**
	 * main方法
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
			reader = new InputStreamReader(TestMainBook.class.getResourceAsStream("/sample.json"), "UTF-8");
			Book book = gson.fromJson(reader, Book.class);
			System.out.println(book);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 反序列化
	}

}
/* 结果是:~
* 
* Book [authors=[Joshua Bloch, Neal Gafter], isbn10=032133678X, isbn13=978-0321336781, title=Java Puzzlers: Traps, Pitfalls, and Corner Cases]
* 成功解析
* 要注意的主要是要对应好类型
*///:~