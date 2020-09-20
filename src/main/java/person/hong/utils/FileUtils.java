package person.hong.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: 洪晓鸿
 * @time: 2020/9/20 23:18
 */

public class FileUtils {

    public static String getContent() {
        String content = null;
        InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream("file/parse.xml");
        try {
            content = IOUtils.toString(inputStream, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
