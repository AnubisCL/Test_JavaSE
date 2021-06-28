package cn.test.IOTest;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试FileInputStream和FileOutStream的使用
 *
 * 结论：
 *  对于文本文件（.txt,.java,.c,.cpp,...），使用字符流
 *  对于非文本文件（.jpg,.mp3,.mp4,.doc,.ppt,...），使用字节流
 */
public class FileInputOutputStreamTest {
    @Test
    public void testFileInputStream(){
        FileInputStream fis = null;
        try {
            //1.造文件对象
            //使用字节流处理文本文件可能会出现乱码
            File file = new File("hello.txt");
            //2.造流对象
            fis = new FileInputStream(file);

            //3.读数据
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer))!=-1){
                String s = new String(buffer,0,len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileInputOutputStream(){

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            //1.造文件对象
            File srcFile = new File("Dva.jpg");
            File destFile = new File("Dva2.jpg");
            //2.造输入输出流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //3.读入和写入操作
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            System.out.println("复制失败");
            e.printStackTrace();
        } finally {
            //4.关闭输入输出流(无先后顺序)
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //指定路径下的复制造作
    public void copyFile(String srcPath,String destPath){

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1.造文件对象
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2.造输入输出流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //3.读入和写入操作
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            System.out.println("复制失败");
            e.printStackTrace();
        } finally {
            //4.关闭输入输出流(无先后顺序)
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();

        String srcPath = "C:\\Users\\17902\\Desktop\\18631741235柴磊.docx";
        String destPath = "C:\\Users\\17902\\Desktop\\2.docx";

        copyFile(srcPath,destPath);

        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为:"+(end-start)+"毫秒");
    }
}
