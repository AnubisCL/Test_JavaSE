package cn.test.exer;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 练习1：客户端给服务端发送文本，服务端会将文本转成大写再返回给客户端
 */
public class exer1 {

    public static void main(String[] args) throws IOException {
        exer1 exer = new exer1();
        exer.keyboardToTxt("D:\\IdeaProject\\Test_JavaSE[初级黑马_自]\\day16【网络编程】\\ABC_LowerCase.txt");
       /* byte[] buffer = {'\\','n'};
        for (int i = 0; i < buffer.length; i++) {
            System.out.println(buffer[i]);
        }*/
    }

    @Test
    public void client() throws IOException{
        //1.创建Socket对象，指明IP地址和端口号
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
        //2.创建输出流
        OutputStream os = socket.getOutputStream();
        //3.创建读入文件流，并指明文件对象
        FileInputStream fis = new FileInputStream(new File("ABC_LowerCase.txt"));
        BufferedInputStream bis = new BufferedInputStream(fis);
        //4.创键缓存数组
        byte[] buffer1 = new byte[20];
        int len1;
        while ((len1 = bis.read(buffer1)) != -1) {
            os.write(buffer1, 0, len1);
        }
        //关闭数据的输出，不然会阻塞
        socket.shutdownOutput();

        //5.接收来自于服务端的文件
        //5.1.创建字节输入流
        InputStream is = socket.getInputStream();
        //5.2.创建文件输出流
        FileOutputStream fos = new FileOutputStream(new File("ABC_UpperCase1.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        //5.3将文件写入
        byte[] buffer = new byte[20];
        int len3;
        while ((len3 = is.read(buffer)) != -1) {
            bos.write(buffer,0,len3);
            bos.flush();
        }

        //6.关闭资源
        //baos.close();
        fis.close();
        os.close();
        socket.close();
    }

    @Test
    public void server() throws IOException{
        //1.创建服务器ServerSocket
        ServerSocket ss = new ServerSocket(9090);
        //2.创建Socket对象
        Socket socket = ss.accept();
        //3.创建字节输入流
        InputStream is = socket.getInputStream();
        //4.创建文件输出流
        FileOutputStream fos = new FileOutputStream(new File("ABC_UpperCase.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        //5.读文件并改变大小写
        byte[] buffer = new byte[20];
        int len;
        while ((len = is.read(buffer)) != -1) {
            for (int i = 0; i < buffer.length; i++) {
                /*if (buffer[i] == 92){
                    buffer[i] = 32;
                    buffer[i+1] = 32;
                    i++;
                    continue;
                    //bos.newLine();
                }*/
                buffer[i] = (byte) (buffer[i] - 32);
            }
            bos.write(buffer,0,len);
            bos.flush();
        }
        System.out.println("大小写变换完成！");

        //6.服务器端给客户端反馈
        OutputStream ops = socket.getOutputStream();
        //3.创建读入文件流，并指明文件对象
        FileInputStream fis = new FileInputStream(new File("ABC_UpperCase.txt"));
        BufferedInputStream bis = new BufferedInputStream(fis);
        //4.创键缓存数组
        byte[] buffer1 = new byte[20];
        int len1;
        while ((len1 = bis.read(buffer1)) != -1) {
            ops.write(buffer1, 0, len1);
        }
        //关闭数据的输出，不然会阻塞
        socket.shutdownOutput();

        //7.
        ops.close();
        fos.close();
        is.close();
        socket.close();
        ss.close();
    }

    /**
     *
     */
    //public void


    /**
     * 查看指定文件名的所有输入的行
     *
     * @param filePath
     */
    public void showAllText(String filePath) {
        FileInputStream fis = null;
        try {
            //1.创建文件字符输出流
            fis = new FileInputStream(new File(filePath));
            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 将键盘输入的值存到指定文件名的文件中,若文件存在则覆盖
     *
     * @param filePath
     */
    public void keyboardToTxt(String filePath) {
        InputStreamReader isr = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //1.创建键盘输入，字符输入流
            isr = new InputStreamReader(System.in);
            //2.创建键盘输入流，缓冲区对象
            br = new BufferedReader(isr);
            //3.将输入内容生成到 "ABC_LowerCase.txt" 文件
            bw = new BufferedWriter(new FileWriter(filePath));
            while (true) {
                System.out.println("Please input something to use keyboard:");
                System.out.println("Enter 'e' to exit.");
                //按行读入
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("======exit======");
                    //结束后遍历文件查看所有输入的行
                    showAllText(filePath);
                    //System.out.println(br.toString());
                    break;
                }
                //3.1写入文件
                bw.write(data);
                bw.newLine(); //提供换行的操作后 \n 换行符无法识别
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (isr != null)
                    isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
