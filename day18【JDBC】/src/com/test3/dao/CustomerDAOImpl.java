package com.test3.dao;

import com.test3.bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @Author: Anubis
 * @Date: 2021-07-02 下午 8:06
 */
public class CustomerDAOImpl extends BaseDAO<Customer> implements CustomerDAO{
    @Override
    public void insert(Connection conn, Customer cust) {
        String sql = "insert into customers(name,email,birth)value(?,?,?)";
        update(conn,sql,cust.getName(),cust.getEmail(),cust.getBirth());
    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from customers where id=?";
        update(conn,sql,id);
    }

    @Override
    public void update(Connection conn, Customer cust) {
        String sql = "update customers set name=?,email=?,birth=? where id=?";
        update(conn,sql,cust.getName(),cust.getEmail(),cust.getBirth(),cust.getId());
    }

    @Override
    public Customer getCustomerById(Connection conn, int id) {
        String sql = "select id,name,email,birth from customers where id=?";
        //此处优化 在BaseDAO 中初始化 clazz 的值不需要此处传值
        Customer customer = getInstance(conn,/*Customer.class,*/ sql, id);
        return customer;
    }

    @Override
    public List<Customer> getAll(Connection conn) {
        String sql = "select id,name,email,birth from customers";
        List<Customer> customerList = getForList(conn,/*Customer.class,*/ sql);
        return customerList;
    }

    @Override
    public Date getMaxBirth(Connection conn) {
        String sql = "select Min(birth) from customers";
        java.sql.Date birthDate = getValue(conn, sql);
        return birthDate;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from customers";
        Long countValue = getValue(conn, sql);
        return countValue;
    }
}
