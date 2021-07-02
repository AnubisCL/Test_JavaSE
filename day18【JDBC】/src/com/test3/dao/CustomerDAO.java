package com.test3.dao;

import com.test3.bean.Customer;

import java.sql.Connection;
import java.util.List;

/**
 * @Author: Anubis
 * @Date: 2021-07-02 下午 7:52
 */
public interface CustomerDAO {

    /**
     * 将 Customer 对象添加到数据库中
     * @param conn
     * @param cust
     */
    void insert(Connection conn, Customer cust);

    /**
     * 根据指定的id删除表中的一条记录
     * @param conn
     * @param id
     */
    void deleteById(Connection conn,int id);

    /**
     * 针对指定的id修改表中的一条记录
     * @param conn
     * @param id
     */
    void updateById(Connection conn, int id);

    /**
     * 根据Id得到指定的Customer对象
     * @param conn
     * @param id
     */
    void getCustomerById(Connection conn,int id);

    /**
     * 查询表中所有记录构成的集合
     * @param conn
     * @return
     */
    List<Customer> getAll(Connection conn);
}
