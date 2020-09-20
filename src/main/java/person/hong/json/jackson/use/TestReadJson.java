package person.hong.json.jackson.use;

import java.io.IOException;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import person.hong.json.jackson.entity.JSONCaseA;

public class TestReadJson {

	@Test
	public void testReadJson() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String inputjsonstr = "{\"city\":\"BeiJing\",\"testa\":123}";
		JSONCaseA readcase = mapper.readValue(inputjsonstr, JSONCaseA.class);
		System.out.println("object info:" + readcase);
	}
	/*
	 * object info:person.hong.json.jackson.entity.JSONCaseA@5d76b067[age=123,unknownAttr=<null>,location=<null>,city=BeiJing]
	 * 1.结果分析
	 * 	ReflectionToStringBuilder.toString(this);
	 * 	重写toString方法的时候使用commons-lang3包的ReflectionToStringBuilder toString方法
	 * 	可以直接输出类的信息以及属性值  方便
	 */
	
	@Test
	public void testMorePropReadJson() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		// 多写了属性会出现以下错误
		// 也没有设置mapper
		// 如果设置了以下mapper的话 也就是忽略没有的属性 这样就不会出错了
		// mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		// Unrecognized field "who" (class person.hong.json.jackson.entity.JSONCaseA), not marked as ignorable (3 known properties: "city", "location", "testa"])
		String inputjsonstr = "{\"city\":\"BeiJing\",\"testa\":123,\"who\":\"zhangsan\"}";
		
		JSONCaseA readcase = mapper.readValue(inputjsonstr, JSONCaseA.class);
		
		System.out.println("object info:" + readcase);
	}
	/* result :)
	 * object info:person.hong.json.jackson.entity.JSONCaseA@76707e36[age=123,unknownAttr=<null>,location=<null>,city=BeiJing]
	 */
}

