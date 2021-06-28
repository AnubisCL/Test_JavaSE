package com.test1.jdbctest;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: Anubis
 * @Date: 2021-06-08 下午 4:12
 */
public class ConnectionTest {

    //方式5（final）：通过读取配置文件的方式获取连接
    @Test
    public void test5() throws Exception {

        //1.读取配置文件的基本信息
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //2.加载驱动
        Class.forName(driverClass);

        //3.获取连接
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);
    }

    //方式4：方式3的优化，可以只是加载驱动，不用注册驱动
    @Test
    public void test4() throws Exception {

        //1.提供三个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";

        //2.加载驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //注册驱动  MySQL的Driver源码中自己在静态代码块注册了
        //DriverManager.registerDriver(driver);

        //3.获取连接
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);
    }

    //方式3：使用DriverManager替换Driver
    @Test
    public void test3() throws Exception {

        //1.获取Driver实现类对象，使用反射
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        //2.提供三个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";

        //注册驱动
        DriverManager.registerDriver(driver);

        //3.获取连接
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);
    }

    //方式2：在如下的程序中不出现第三方API，使得具有更好的可移植性
    @Test
    public void test2() throws Exception {
        //1.获取Driver实现类对象，使用反射
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        //2.提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/test";

        //3.将用户名和密码封装在Properties中
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        //4.获取连接
        Connection connect = driver.connect(url, info);

        System.out.println(connect);
    }

    //方式1：
    @Test
    public void test1() throws SQLException {
        //出现了第三方API,获取Driver对象
        Driver driver = new com.mysql.jdbc.Driver();
        //              协议      |  IP地址  |端口号|数据库
        String url = "jdbc:mysql://localhost:3306/test";
        //将用户名和密码封装在Properties中
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        Connection connect = driver.connect(url, info);

        System.out.println(connect);


    }
}
