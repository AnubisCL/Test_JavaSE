package com.test1.preparedstatment;

import com.test1.bean.Customer;
import com.test1.bean.Order;
import com.test1.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Description 使用PreparedStatement实现针对于不同表的通用的查询操作
 * @author shkstart Email:shkstart@126.com
 * @version
 * @date 上午11:32:55
 *
 */
public class PreparedStatementQueryTest {
	
	@Test
	public void testGetForList(){
		
		String sql = "select id,name,email from customers where id < ?";
		List<Customer> list = getForList(Customer.class,sql,12);
		list.forEach(System.out::println);
		
		String sql1 = "select order_id orderId,order_name orderName from `order`";
		List<Order> orderList = getForList(Order.class, sql1);
		orderList.forEach(System.out::println);
	}
	
	public <T> List<T> getForList(Class<T> clazz,String sql, Object... args){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			rs = ps.executeQuery();
			// 获取结果集的元数据 :ResultSetMetaData
			ResultSetMetaData rsmd = rs.getMetaData();
			// 通过ResultSetMetaData获取结果集中的列数
			int columnCount = rsmd.getColumnCount();
			//创建集合对象
			ArrayList<T> list = new ArrayList<T>();
			while (rs.next()) {
				T t = clazz.newInstance();
				// 处理结果集一行数据中的每一个列:给t对象指定的属性赋值
				for (int i = 0; i < columnCount; i++) {
					// 获取列值
					Object columValue = rs.getObject(i + 1);
					// 获取每个列的列名
					// String columnName = rsmd.getColumnName(i + 1);
					String columnLabel = rsmd.getColumnLabel(i + 1);
					// 给t对象指定的columnName属性，赋值为columValue：通过反射
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columValue);
				}
				list.add(t);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, ps, rs);
		}
		return null;
	}
	
	@Test
	public void testGetInstance(){
		String sql = "select id,name,email from customers where id = ?";
		Customer customer = getInstance(Customer.class,sql,12);
		System.out.println(customer);
		
		String sql1 = "select order_id orderId,order_name orderName from `order` where order_id = ?";
		Order order = getInstance(Order.class, sql1, 1);
		System.out.println(order);
	}
	/**
	 * 
	 * @Description 针对于不同的表的通用的查询操作，返回表中的一条记录
	 * @author shkstart
	 * @date 上午11:42:23
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T> T getInstance(Class<T> clazz,String sql, Object... args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			//1.获取连接
			conn = JDBCUtils.getConnection();
			//2.获取prepareStatement对象
			ps = conn.prepareStatement(sql);
			//3.填充占位符
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1,args[i]);
			}
			//4.获取结果集
			rs = ps.executeQuery();
			//4.1获取结果集的元数据（private String ____;）
			ResultSetMetaData rsmd = rs.getMetaData();
			//4.2获取结果集的列数
			int columnCount = rsmd.getColumnCount();
			//5.遍历结果集
			if (rs.next()){
				T t = clazz.newInstance();
				for (int i = 0; i < columnCount; i++) {
					//5.1获取每个列的列值:通过 ResultSet
					Object columnValue = rs.getObject(i + 1);
					//5.2获取每个列的列名（字段名）：通过 ResultSetMetaData
					//getColumnName() : 获取表的列名
					//String columnName = rsmd.getColumnName(i+1);
					//getColumnName() : 获取列的别名
					String columnLabel = rsmd.getColumnLabel(i+1);
					//5.3通过反射获取 t 对象指定的名为 columnName 的属性，将其设为可更改，并赋值为指定的 columnValue
					Field field = clazz.getDeclaredField(columnLabel);
					//设置对象属性为可更改
					field.setAccessible(true);
					field.set(t, columnValue);
				}
				return t;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//6.关闭资源
			JDBCUtils.closeResource(conn, ps, rs);
		}
		return null;
	}

}
