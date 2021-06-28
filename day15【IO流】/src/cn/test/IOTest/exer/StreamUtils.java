package cn.test.IOTest.exer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtils {

    /**
     * 功能：将输入流转换成byte[],即可以把文件的内容读入到byte[]
     * @param is
     * @return
     */
    public static byte[] streamToByteArray(InputStream is) {
        ByteArrayOutputStream baos = null;
        byte[] array;
        try {
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }
            array = baos.toByteArray();  //将整个文件的baos对象装换为byte数组
            return array;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos!=null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
