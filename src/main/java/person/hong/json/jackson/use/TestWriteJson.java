package person.hong.json.jackson.use;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import person.hong.json.jackson.entity.JSONCaseA;

public class TestWriteJson {
	 
	@Test
	public void writeJson() throws JsonProcessingException {
 
		ObjectMapper mapper = new ObjectMapper();
 
		JSONCaseA case1 = new JSONCaseA();
		case1.setCity("BeiJing");
 
		case1.setUnknownAttr("testVal");
		case1.setAge(123);
 
		String jsonStr = mapper.writeValueAsString(case1);
 
		System.out.println("JSON:" + jsonStr);
	}
}
/*
 * result:)
JSON:{"city":"BeiJing","testa":123}
结果分析；
利用注解使用别名
以及不进行序列化
 */
