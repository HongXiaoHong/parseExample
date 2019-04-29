package person.hong.json.fastjson.use;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import person.hong.json.fastjson.entity.Student;
import person.hong.json.fastjson.entity.Teacher;
/**
 * bean相关的序列化以及反序列化
 * @author 洪晓鸿     
 * @date   2019年4月29日 上午10:28:43   
 * @version V1.0
 */
public class BeanUse {

	//json字符串-简单对象型
	private static final String  JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";
	//json字符串-数组类型
	private static final String  JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";
	//复杂格式json字符串
	private static final String  COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";
	
	public BeanUse() {
		super();
	}

	/**
	 * 简单对象 bean 反序列化
	 */
	@Test
	public void sampleDeSerialization() {
		Student stu = JSONObject.parseObject(JSON_OBJ_STR, Student.class);
		System.out.println("序列化的对象Student(自动调用toString方法)");
		System.out.println(stu);
	}
	/* 结果 :)
	 序列化的对象Student(自动调用toString方法)
	Student [studentName=lily, studentAge=12]
	 */
	/**
	 *  序列化 即 bean-->String
	 */
	@Test
	public void sampleSerialization() {
		Student stu = new Student("Hong", "24");
		String jsonString = JSONObject.toJSONString(stu);
		System.out.println("序列化得到的字符串");
		System.out.println(jsonString);
	}
	/*
	 序列化得到的字符串
	{"studentAge":"24","studentName":"Hong"}
	 */
	/**
	 * 数组序列化
	 */
	@Test
	public void arraySerialization() {
		List<Student> stuArr = new ArrayList<Student>();
		Student stuOne = new Student("Hong", "24");
		Student stuTwo = new Student("Ping", "24");
		stuArr.add(stuOne);
		stuArr.add(stuTwo);
		String jsonString = JSONArray.toJSONString(stuArr);
		System.out.println(jsonString);
	}
	/*result:)
	 * [{"studentAge":"24","studentName":"Hong"},{"studentAge":"24","studentName":"Ping"}]
	 */
	/**
	 * 数组反序列化
	 */
	@Test
	public void arrayDeSerialization() {
		List<Student> stuArr = JSONArray.parseArray(JSON_ARRAY_STR, Student.class);
		// 反序列化成功后 输出生成的list集合
		Iterator<Student> iterator = stuArr.iterator();
		while (iterator.hasNext()) {
			Student stu = iterator.next();
			System.out.println(stu);
		}
		
		//第二种方式,使用TypeReference<T>类,由于其构造方法使用protected进行修饰,故创建其子类
	    List<Student> studentList = JSONArray.parseObject(JSON_ARRAY_STR, new TypeReference<ArrayList<Student>>() {});
	    System.out.println("studentList:  " + studentList);
	}
	/* result:)
	 * Student [studentName=lily, studentAge=12]
		Student [studentName=lucy, studentAge=15]
		studentList:  [Student [studentName=lily, studentAge=12], Student [studentName=lucy, studentAge=15]]
	 */
	/**
	 * 复杂json格式字符串到JavaBean_obj的转换
	 */
	@Test
	public void testComplexJSONStrToJavaBean(){

	    //第一种方式,使用TypeReference<T>类,由于其构造方法使用protected进行修饰,故创建其子类
	    Teacher teacher = JSONObject.parseObject(COMPLEX_JSON_STR, new TypeReference<Teacher>() {});
	    System.out.println(teacher);

	    //第二种方式,使用Gson思想
	    Teacher teacher1 = JSONObject.parseObject(COMPLEX_JSON_STR, Teacher.class);
	    System.out.println(teacher1);
	}
	/*
	Teacher [teacherName=crystall, teacherAge=27, students=[Student [studentName=lily, studentAge=12], Student [studentName=lucy, studentAge=15]], course=Course [courseName=english, code=1270]]
	Teacher [teacherName=crystall, teacherAge=27, students=[Student [studentName=lily, studentAge=12], Student [studentName=lucy, studentAge=15]], course=Course [courseName=english, code=1270]]
	 */
	/**
	 * 复杂JavaBean_obj到json格式字符串的转换
	 */
	@Test
	public void testJavaBeanToComplexJSONStr(){

	    //已知复杂JavaBean_obj
	    Teacher teacher = JSONObject.parseObject(COMPLEX_JSON_STR, new TypeReference<Teacher>() {});
	    String jsonString = JSONObject.toJSONString(teacher);
	    System.out.println(jsonString);
	}
	/*
	{"course":{"code":1270,"courseName":"english"},"students":[{"studentAge":"12","studentName":"lily"},{"studentAge":"15","studentName":"lucy"}],"teacherAge":"27","teacherName":"crystall"}
	 */
}
