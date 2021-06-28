package cn.test.IOTest.exer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PicTest {

    //图片加密
    @Test
    public void test1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("Dva.jpg");
            fos = new FileOutputStream("Dva_Secert.jpg");

            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }


    //图片解密
    @Test
    public void test2() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("Dva_Secert.jpg");
            fos = new FileOutputStream("Dva_Sounce.jpg");

            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
