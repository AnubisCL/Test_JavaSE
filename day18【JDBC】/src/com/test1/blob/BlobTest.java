package com.test1.blob;

import com.test1.bean.Customer;
import com.test1.util.JDBCUtils;
import org.junit.Test;

import java.io.*;
import java.sql.*;

/**
 * @Author: Anubis
 * @Date: 2021-06-09 下午 4:08
 * 测试使用PreparedStatement操作Blob类型的数据
 */
public class BlobTest {

    //向数据表customers中插入Blob类型的字段
    @Test
    public void test1() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into customers(name,email,birth,photo)value(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,"柴磊");
            ps.setObject(2,"anubiscl2163.com");
            ps.setObject(3,"1999-03-21");
            FileInputStream fis = new FileInputStream(new File("source\\chailei.jpg"));
            ps.setBlob(4,fis);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }

    }

    //向数据表customers中读取Blob类型的字段
    @Test
    public void test2(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id,name,email,birth,photo from customers where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,20);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birth = rs.getDate("birth");
                Customer customer = new Customer(id,name,email,birth);
                System.out.println(customer.toString());

                Blob photo = rs.getBlob("photo");
                is = photo.getBinaryStream();
                fos = new FileOutputStream("source\\chailei2.jpg");
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer))!=-1){
                    fos.write(buffer,0,len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps,rs);
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }


}
