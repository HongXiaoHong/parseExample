package person.hong.json.gson.base;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import com.google.gson.Gson;

public class ReadJsonApp {

	public static void main(String[] args) {
		Reader reader = null;
		try {
			Gson gson = new  Gson();
			// 存放位置放在项目
			reader = new InputStreamReader(ReadJsonApp.class.getClassLoader().getResourceAsStream("output.json"), "UTF-8");
			Person person = gson.fromJson(reader, Person.class);
			System.out.println(person);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
/* 结果：
 * Person [id=1, name=Hong, location=GZ, phone=Phone [number=1522000****, price=1599.0]]
 * 结果分析：
 * 对象里面有对象gson也会帮我们设置进去 这里的Person对象包含了Phone对象 属于聚合关系
 */
