package person.hong.json.fastjson.use;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import person.hong.json.fastjson.entity.Student;


public class BasicUse {

    //json字符串-简单对象型
    private static final String JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";

    //json字符串-数组类型
    private static final String JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";

    //复杂格式json字符串
    private static final String COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

    @Test
    public void sampleJson() {
        Student stu = JSONObject.parseObject(JSON_OBJ_STR, Student.class);
        System.out.println(stu);

        String stuJson = JSONObject.toJSONString(stu);
        System.out.println(stuJson);

        JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);
        System.out.println(jsonObject);

        String objJson = JSONObject.toJSONString(jsonObject);
        System.out.println(objJson);
    }
	/*
	 * 结果 :)
	 Student [studentName=lily, studentAge=12]
	{"studentAge":"12","studentName":"lily"}
	{"studentAge":12,"studentName":"lily"}
	{"studentAge":12,"studentName":"lily"}
	 */

    @Test
    public void arrsyJson() {
        // 序列化
        JSONArray jsonArray = JSONObject.parseArray(JSON_ARRAY_STR);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObj = jsonArray.getJSONObject(i);
            System.out.println(jsonObj);
        }
        // 反序列化
        // 因为对象的toString方法已经重写 会自动调用 toJSONString 方法
        System.out.println(jsonArray);
    }
	/*
	 * 结果 :)
	 {"studentAge":12,"studentName":"lily"}
	{"studentAge":15,"studentName":"lucy"}
	[{"studentAge":12,"studentName":"lily"},{"studentAge":15,"studentName":"lucy"}]
	 */

    /**
     * 复杂json格式字符串到JSONObject的转换
     */
    @Test
    public void testComplexJSONStrToJSONObject() {

        JSONObject jsonObject = JSONObject.parseObject(COMPLEX_JSON_STR);

        String teacherName = jsonObject.getString("teacherName");
        Integer teacherAge = jsonObject.getInteger("teacherAge");

        System.out.println("teacherName:  " + teacherName + "   teacherAge:  " + teacherAge);

        JSONObject jsonObjectcourse = jsonObject.getJSONObject("course");
        //获取JSONObject中的数据
        String courseName = jsonObjectcourse.getString("courseName");
        Integer code = jsonObjectcourse.getInteger("code");

        System.out.println("courseName:  " + courseName + "   code:  " + code);

        JSONArray jsonArraystudents = jsonObject.getJSONArray("students");

        //遍历JSONArray
        for (Object object : jsonArraystudents) {

            JSONObject jsonObjectone = (JSONObject) object;
            String studentName = jsonObjectone.getString("studentName");
            Integer studentAge = jsonObjectone.getInteger("studentAge");

            System.out.println("studentName:  " + studentName + "   studentAge:  " + studentAge);
        }
    }
	/* 结果 :)
	courseName:  english   code:  1270
	studentName:  lily   studentAge:  12
	studentName:  lucy   studentAge:  15
	 */

    /**
     * 复杂JSONObject到json格式字符串的转换
     */
    @Test
    public void testJSONObjectToComplexJSONStr() {

        //复杂JSONObject,目标要转换为json字符串
        JSONObject jsonObject = JSONObject.parseObject(COMPLEX_JSON_STR);

        //第一种方式
        //String jsonString = JSONObject.toJSONString(jsonObject);

        //第二种方式
        String jsonString = jsonObject.toJSONString();
        System.out.println(jsonString);

    }
	/* 结果 :)
	{"teacherAge":27,"teacherName":"crystall","course":{"courseName":"english","code":1270},"students":[{"studentAge":12,"studentName":"lily"},{"studentAge":15,"studentName":"lucy"}]}
	 */
}
