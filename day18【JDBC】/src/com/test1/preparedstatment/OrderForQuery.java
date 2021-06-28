package com.test1.preparedstatment;

import com.test1.bean.Order;
import com.test1.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;


/**
 * 
 * @Description 针对于Order表的通用的查询操作
 * @author shkstart  Email:shkstart@126.com
 * @version 
 * @date 上午10:43:58
 *
 */
public class OrderForQuery {
	/*
	 * 针对于表的字段名与类的属性名不相同的情况：
	 * 1. 必须声明sql时，使用类的属性名来命名字段的别名
	 * 2. 使用ResultSetMetaData时，需要使用getColumnLabel()来替换getColumnName(),
	 *    获取列的别名。
	 *  说明：如果sql中没有给字段其别名，getColumnLabel()获取的就是列名
	 */
	@Test
	public void testOrderForQuery(){
		/*
		* java.lang.NoSuchFieldException: order_id
		* 不取别名则会报错，因为 Order 对象的属性名 与 数据库表列名 不一致
		* */
		String sql = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
		Order order = orderForQuery(sql,4);
		System.out.println(order);
	}
	
	/**
	 * 
	 * @Description 通用的针对于order表的查询操作
	 * @author shkstart
	 * @date 上午10:51:12
	 * @return
	 * @throws Exception 
	 */
	public Order orderForQuery(String sql,Object...args){
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
				Order order = new Order();
				for (int i = 0; i < columnCount; i++) {
					//5.1获取每个列的列值:通过 ResultSet
					Object columnValue = rs.getObject(i + 1);
					//5.2获取每个列的列名（字段名）：通过 ResultSetMetaData
					//getColumnName() : 获取表的列名
					//String columnName = rsmd.getColumnName(i+1);
					//getColumnName() : 获取列的别名
					String columnLabel = rsmd.getColumnLabel(i+1);
					//5.3通过反射获取 Order 对象指定的名为 columnName 的属性，将其设为可更改，并赋值为指定的 columnValue
					Field field = Order.class.getDeclaredField(columnLabel);
					//设置对象属性为可更改
					field.setAccessible(true);
					field.set(order, columnValue);
				}
				return order;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//6.关闭资源
			JDBCUtils.closeResource(conn, ps, rs);
		}
		return null;
	}

	/**
	 * 查询 Order 表
	 */
	@Test
	public void testQuery1(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select order_id,order_name,order_date from `order` where order_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, 1);
			
			rs = ps.executeQuery();
			if(rs.next()){
				int id = (int) rs.getObject(1);
				String name = (String) rs.getObject(2);
				Date date = (Date) rs.getObject(3);
				
				Order order = new Order(id, name, date);
				System.out.println(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			JDBCUtils.closeResource(conn, ps, rs);
		}
	}
}
