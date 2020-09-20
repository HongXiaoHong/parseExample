package person.hong.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @description: SAX解析DOM 一行一行  Handler startElement endElement
 * @author: 洪晓鸿
 * @time: 2020/9/20 23:29
 */
public class SaxDemo {

    public static void main(String[] args) throws Exception {
        // 1.或去SAXParserFactory实例
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // 2.获取SAXparser实例
        SAXParser saxParser = factory.newSAXParser();
        // 创建Handel对象
        SaxDemoHandle handel = new SaxDemoHandle();
        saxParser.parse("src/main/java/file/parse.xml", handel);
    }
}

class SaxDemoHandle extends DefaultHandler {
    /**
     * @Description 遍历xml文件开始标签
     * @Time 2020/9/20 23:56
     * @Author 洪晓鸿
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("sax解析开始");
    }

    /**
     * @Description 遍历xml文件结束标签
     * @Time 2020/9/20 23:56
     * @Author 洪晓鸿
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("sax解析结束");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if ("student".equals(qName)) {
            System.out.println("============开始遍历student=============");
            // System.out.println(attributes.getValue("rollno"));
        } else if (!"student".equals(qName) && !"class".equals(qName)) {
            System.out.print("节点名称:" + qName + "----");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals("student")) {
            System.out.println(qName + "遍历结束");
            System.out.println("============结束遍历student=============");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String value = new String(ch, start, length).trim();
        if (!value.equals("")) {
            System.out.println(value);
        }
    }
}
