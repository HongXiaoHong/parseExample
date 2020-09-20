package person.hong.xml.dom;

/**
 * @description:
 * @author: 洪晓鸿
 * @time: 2020/9/20 23:23
 */

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * @Author: cxx
 * Dom操作xml
 * @Date: 2018/5/29 20:19
 */
public class DomDemo {
    /**
     * @Description 用Element方式
     * @Time 2020/9/20 23:49
     * @Author 洪晓鸿
     */
    public static void element(NodeList list) {
        for (int i = 0; i < list.getLength(); i++) {
            Element element = (Element) list.item(i);
            outputNodeList(element);
        }
    }

    public static void node(NodeList list) {
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            outputNodeList(node);
        }
    }

    private static void outputNodeList(Node node) {
        NodeList childNodes = node.getChildNodes();
        for (int j = 0; j < childNodes.getLength(); j++) {
            if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                System.out.print(childNodes.item(j).getNodeName() + ":");
                System.out.println(childNodes.item(j).getFirstChild().getNodeValue());
            }
        }
    }

    public static void main(String[] args) {
        //1.创建DocumentBuilderFactory对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //2.创建DocumentBuilder对象
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document d = builder.parse("src/main/java/file/parse.xml");
            NodeList sList = d.getElementsByTagName("student");
            //element(sList);
            node(sList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}