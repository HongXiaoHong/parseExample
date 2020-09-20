package person.hong.json.fastjson.entity;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestMain {

    private static List<Person> listOfPersons = new ArrayList<Person>();

    public static void main(String[] args) {
        listOfPersons.add(new Person(15, "John Doe", new Date()));
        listOfPersons.add(new Person(20, "Janette Doe", new Date()));
        String jsonOutput = JSON.toJSONString(listOfPersons);
        System.out.println(jsonOutput);
    }

}
/* 结果：
 * [{"AGE":15,"DATE OF BIRTH":1556467617435,"FULL NAME":"John Doe"},{"AGE":20,"DATE OF BIRTH":1556467617435,"FULL NAME":"Janette Doe"}]
 *
 */
