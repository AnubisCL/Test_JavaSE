package com.test2.transaction;

import com.test2.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

public class ConnectionTest {
	
	@Test
	public void testGetConnection() throws Exception{
		Connection conn = JDBCUtils.getConnection();
		System.out.println(conn);
	}
}
