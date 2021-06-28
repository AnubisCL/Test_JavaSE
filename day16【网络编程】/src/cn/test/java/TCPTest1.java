package cn.test.java;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPTest1 {

    @Test
    public void client1() {
        Socket socket = null;
        OutputStream os = null;

        try {
            //1.创建Socket对象，指明服务器端的ip和端口号
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            //Socket(InetAddress address, int port) : 创建一个流套接字并将其连接到指定 IP 地址的指定端口号。
            socket = new Socket(inetAddress, 9090);

            //2.获取一个输出流，用于输出数据
            os = socket.getOutputStream();
            //3.写数据操作
            os.write("你好，我是客户端1[127.0.0.1]".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            if (os != null)
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (socket != null)
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            //1.创建服务器端的ServerSocket，指明自己的端口号
            ss = new ServerSocket(9090);
            //2.调用 accept() 表示接收来自于客户端的 socket
            socket = ss.accept();
            //3.获取输入流
            is = socket.getInputStream();

            //不建议这样写，可能会有乱码
        /*byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            String str = new String(buffer,0,len);
            System.out.print(str);
        }*/
            //4.读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }

            System.out.println(baos.toString());

            System.out.println("收到了来自于：" + socket.getInetAddress().getHostAddress() + "的数据");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
