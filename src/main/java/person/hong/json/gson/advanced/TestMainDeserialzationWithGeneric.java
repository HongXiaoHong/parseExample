package person.hong.json.gson.advanced;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * 测试类 测试自己实现反序列化接口
 * @author 洪晓鸿     
 * @date   2019年4月27日 下午5:20:55   
 * @version V1.0
 */
public class TestMainDeserialzationWithGeneric {

	/**
	 * main方法
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
					reader = new InputStreamReader(TestMainBook.class.getResourceAsStream("/result.json"), "UTF-8");
					Result<User[]> result = gson.fromJson(reader, new TypeToken<Result<User[]>>() {}.getType());
					System.out.println(result);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
	}

}
/* 结果是:~
* 
* Result [code=0, message=success, data=[Lperson.hong.json.gson.advanced.User;@25f38edc]

* 不使用自定义序列化的接口
* 也可以反序列化成功
* 使用泛型可以使用data多种类型
* gson支持泛型 很方便
* 注意点：
* TypeToken的构造方法是protected修饰的,所以上面才会写成new TypeToken<List<String>>() {}.getType() 
* 而不是 new TypeToken<List<String>>().getType()
* 
*///:~