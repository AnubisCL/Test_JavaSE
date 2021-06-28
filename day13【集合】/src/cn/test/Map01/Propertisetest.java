package cn.test.Map01;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Propertisetest {

    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();

        FileInputStream fileInputStream = new FileInputStream("D:\\IdeaProject\\Test_JavaSE[初级黑马_自]\\day13【集合】\\src\\cn\\test\\Map01\\jdbc.properties");

        properties.load(fileInputStream);   //加载对用的流文件

        String name = properties.getProperty("name");
        String password = properties.getProperty("password");

        System.out.println("{name="+name+" ,password="+password+"}");

        fileInputStream.close();

    }
}
