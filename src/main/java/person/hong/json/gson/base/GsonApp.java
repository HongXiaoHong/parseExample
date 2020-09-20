package person.hong.json.gson.base;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import com.google.gson.Gson;

public class GsonApp {

	public static void main(String[] args) {
		Writer writer = null;
		try {
			Gson gson = new  Gson();
			// 通过泛型将json字符串转换为泛型声明的类型
			@SuppressWarnings("rawtypes")
			Map result = gson.fromJson("{\"id\":1}", Map.class);
			System.out.println(result.get("id"));
			// 后面的参数可以设置显示的位置
			gson.toJson(result, System.out);
			// 存放位置放在项目
			writer = new FileWriter("output.json");
			gson.toJson(result, writer);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
