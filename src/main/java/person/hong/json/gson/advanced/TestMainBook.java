package person.hong.json.gson.advanced;

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
		GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
		// 创建gson对象 使用默认的序列化器
		Gson gson = builder.create();//= new Gson();
		
		// 创建book
		final Book book = new Book();
		book.setTitle("Java 编程思想");
		book.setIsbn10("isbn10-032133678X");
		book.setIsbn13("978-7-111-21250-8");
		book.setAuthors(new String[] {"Bruce Eckel","陈昊鹏"});
		// 序列化		
		String json = gson.toJson(book);
		System.out.println("json:"+json);
	}

}
/* 结果是:~
* 
* json:{"authors":["Bruce Eckel","陈昊鹏"],"isbn-10":"isbn10-032133678X","isbn-13":"978-7-111-21250-8","title":"Java 编程思想"}

* 不使用自定义序列化的接口
* 也可以序列化成功
* 而且序列化字段跟注解的一样
* 原来是跟原字段 名字一样
* 后面是跟注解的名字一样
* 
* 使用GsonBuilder 创建的gson对象同样输出的是没有格式化的json对象
* json:{"authors":["Bruce Eckel","陈昊鹏"],"isbn-10":"isbn10-032133678X","isbn-13":"978-7-111-21250-8","title":"Java 编程思想"}
* setPrettyPrinting
* 该方法用于美化json数据
*///:~