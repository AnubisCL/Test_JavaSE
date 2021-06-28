package cn.test.java;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题2.5：客户端发送文件给服务端，服务端将文件保存在本地，并返回发送成功给客户端。
 */
public class TCPTest3 {

    /*
    这里涉及到的异常，应该使用try-catch-finally处理
     */
    @Test
    public void client() throws IOException {
        //1.创建Socket对象，指明IP地址和端口号
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
        //2.创建输出流
        OutputStream os = socket.getOutputStream();
        //3.创建读入文件流，并指明文件对象
        FileInputStream fis = new FileInputStream(new File("Dva.jpg"));
        //4.创键缓存数组
        byte[] buffer1 = new byte[1024];
        int len1;
        while ((len1 = fis.read(buffer1)) != -1) {
            os.write(buffer1, 0, len1);
        }

        //关闭数据的输出，不然会阻塞
        socket.shutdownOutput();

        //5.接收来自于服务端的信息，并显示到控制台上。
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[20];
        int len2;
        while ((len2 = inputStream.read(buffer2)) != -1) {
            baos.write(buffer2, 0, len2);
        }
        System.out.println(baos.toString());


        //6.关闭资源
        baos.close();
        fis.close();
        os.close();
        socket.close();

    }

    /*
    这里涉及到的异常，应该使用try-catch-finally处理
     */
    @Test
    public void server() throws IOException {
        //1.
        ServerSocket ss = new ServerSocket(9090);
        //2.
        Socket socket = ss.accept();
        //3.
        InputStream is = socket.getInputStream();
        //4.
        FileOutputStream fos = new FileOutputStream(new File("Dva1.jpg"));
        //5.
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        System.out.println("图片传输完成！");
        //6.服务器端给客户端反馈
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("发送成功!".getBytes());

        //7.
        outputStream.close();
        fos.close();
        is.close();
        socket.close();
        ss.close();

    }
}
