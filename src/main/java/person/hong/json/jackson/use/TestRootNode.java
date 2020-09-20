package person.hong.json.jackson.use;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import person.hong.json.jackson.entity.JsonCaseB;

public class TestRootNode {

    @Test
    public void testRootNode() throws JsonProcessingException {
        JsonCaseB caseb = new JsonCaseB();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);

        caseb.setAddress("changeAddress");
        caseb.setAge(123);
        caseb.setSex("Boy");

        String jsonStr = mapper.writeValueAsString(caseb);

        System.out.println("JSON:" + jsonStr);
    }
}
/*
 * JSON:{"rootNode":{"address":$#,"age":123}}
 *  1. @JsonRootName
 *  	可以改变输出的时候的根节点
 *  	如果ObjectMapper没有使用 .enable(SerializationFeature.WRAP_ROOT_VALUE);方法
 * 		也是无法改变根节点的
 *  2. @JsonInclude(JsonInclude.Include.NON_EMPTY)
 *  	在类上声明 如果属性为空则不输出
 *  3. @JsonRawValue
 *  	该属性值原样输出
 *  	例如字符串就不会加上双引号
 *  	JSON:{"rootNode":{"address":changeAddress,"age":0}}----使用后
 *  	JSON:{"rootNode":{"address":"changeAddress","age":0}}--使用前
 */
