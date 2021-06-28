package cn.test.exer;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 练习2：服务端读取图片并发送给客户端，客户端保存到本地
 */
public class exer2 {

    @Test
    public void client() throws IOException {

        System.out.println("下载开始");

        //1.创建Socket对象
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
        //2.创建Socket文件输入字节流
        InputStream is = socket.getInputStream();
        //3.创建文件输出字节流
        FileOutputStream fos = new FileOutputStream("Dva_c2.jpg");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        System.out.println("下载成功");

        //4.关闭流
        fos.close();
        is.close();
        socket.close();
    }

    @Test
    public void server() throws IOException{


        //1.创建服务端 ServerSocket
        ServerSocket serverSocket = new ServerSocket(9090);
        //2.调用 accept() 表示接收来自于客户端的 socket
        Socket socket = serverSocket.accept();
        //2.创建文件读入字节流
        FileInputStream fis = new FileInputStream("Dva.jpg");
        //3.创建Socket输出流
        OutputStream os = socket.getOutputStream();

        //创建数组缓存读入的图片
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer))!=-1){   //将图片读入到字节数组缓存
            os.write(buffer,0,len);     //将数组内容写入到Socket输出流
        }
        //读入完成后，关闭Socket输出流的读入操作，不然会阻塞与此
        socket.shutdownOutput();
        System.out.println("服务端已传输到总线");
        //4.关闭流
        os.close();
        fis.close();
        socket.close();

    }
}

