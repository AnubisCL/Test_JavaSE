package cn.test.NIOTest;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2019 上午 11:58
 */
public class FileUtilsTest {

    public static void main(String[] args) {
        File srcFile = new File("day15【IO流】\\Dva.jpg");
        File destFile = new File("day15【IO流】\\Dva3.jpg");

        try {
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
