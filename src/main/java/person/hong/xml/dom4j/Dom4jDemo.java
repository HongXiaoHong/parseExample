package person.hong.xml.dom4j;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * @description: Dom4j解析xml
 * @author: 洪晓鸿
 * @time: 2020/9/20 23:39
 */
public class Dom4jDemo {
    public static void main(String[] args) throws Exception {
        // 1.创建Reader对象
        SAXReader reader = new SAXReader();
        // 2.加载xml
        Document document = reader.read(new File("src/main/java/file/parse.xml"));
        // 3.获取根节点
        Element rootElement = document.getRootElement();
        Iterator<Element> iterator = rootElement.elementIterator();
        while (iterator.hasNext()) {
            Element stu = iterator.next();
            List<Attribute> attributes = stu.attributes();
            System.out.println("======获取属性值======");
            for (Attribute attribute : attributes) {
                System.out.println(attribute.getValue());
            }
            System.out.println("======遍历子节点======");
            Iterator<Element> iterator1 = stu.elementIterator();
            while (iterator1.hasNext()) {
                Element stuChild = iterator1.next();
                System.out.println("节点名：" + stuChild.getName() + "---节点值：" + stuChild.getStringValue());
            }
        }
    }
}
