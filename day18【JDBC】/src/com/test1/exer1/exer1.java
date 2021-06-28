package com.test1.exer1;

import com.test1.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * @Author: Anubis
 * @Date: 2021-06-09 下午 3:00
 */
public class exer1 {

    /**
     * 练习1：从控制台向数据库表Customer中插入一条数据
     */
    public static void main(String[] args) {
        exer1 exer1 = new exer1();

        Scanner scanner = new Scanner(System.in);
        System.out.print("name :");
        String name = scanner.next();
        System.out.print("email :");
        String email = scanner.next();
        System.out.print("birth(yyyy-MM-dd) :");
        String birth = scanner.next();

        System.out.println(name+"\t"+email+"\t"+ birth);
        String sql = "insert into customers(name,email,birth)values(?,?,?)";
        System.out.println(exer1.instertTest(sql, name, email, birth) > 0?"成功！":"失败！");

    }

    public int instertTest(String sql,Object ... args){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(1+i,args[i]);
            }
            /*
            * ps.execute();
            * 1.无返回结果集 -> true
            * 2.有返回结果集 -> false
            * */
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }
        return 0;
    }
}
