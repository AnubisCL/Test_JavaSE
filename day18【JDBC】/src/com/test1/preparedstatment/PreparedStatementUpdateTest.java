package com.test1.preparedstatment;

import com.test1.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
/**
 * @Author: Anubis
 * @Date: 2021-06-08 下午 8:29
 */
public class PreparedStatementUpdateTest {


    @Test
    public void testUpdate(){
        //String sql = "delete from customers where id = ?";
        //update(sql,21);

        String sql = "update `order` set order_name = ? where order_id = ?";
        update(sql,"CC","4");

    }

    //通用的增删改操作
    public void update(String sql, Object ... args){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库连接
            conn = JDBCUtils.getConnection();
            //2.预编译Sql语句，返回PreparedStatment的实例
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(1+i,args[i]);
            }
            //4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭
            JDBCUtils.closeResource(conn,ps);
        }


    }

    //修改Customer表的一条记录
    @Test
    public void test2() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.获取工具类连接
            conn = JDBCUtils.getConnection();

            //2.预编译SQL语句，返回PreparedStatement实例
            String sql = "update customers set name = ? where id = ?";
            ps = conn.prepareStatement(sql);

            //3.填充占位符
            ps.setObject(1,"A贝多芬A");
            ps.setObject(2,18);

            //4.执行SQL语句
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            JDBCUtils.closeResource(conn,ps);
        }
    }

    //向Customers表添加一条记录
    @Test
    public void test1() {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1.读取配置信息
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties pros = new Properties();
            pros.load(is);
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driverClass = pros.getProperty("driverClass");

            //2.加载驱动
            Class.forName(driverClass);

            //3.获取连接
            connection = DriverManager.getConnection(url,user,password);
            System.out.println(connection);

            //4.插入操作，预编译sql语句，返回PreparedStatement的实例
            String sql = "insert into customers(name, email, birth)value (?,?,?)";  //？占位符
            ps = connection.prepareStatement(sql);

            //5.填充占位符
            ps.setString(1,"哪吒");
            ps.setString(2,"nezha@gmail.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("1000-01-01");
            ps.setDate(3,new Date(date.getTime()));

            //6.执行SQL
            ps.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            //7.关闭资源
            if (ps!=null){
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }

    }
}
