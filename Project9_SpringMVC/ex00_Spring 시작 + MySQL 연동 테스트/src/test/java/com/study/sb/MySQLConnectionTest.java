package com.study.sb;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class MySQLConnectionTest {

	private static final String driverClassName = "com.mysql.jdbc.Driver";
	private static final String db = "ex";
	private static final String driverUrl = "jdbc:mysql://localhost:3306/" + db + "?useSSL=false";
	private static final String user = "root";
	private static final String password = "root";
	
	@Test
	public void test() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			fail("ClassNotFoundException while loading Driver class: " + e.getMessage());
		}

		try (Connection con = DriverManager.getConnection(driverUrl, user, password)) {	
			assertNotNull(con);		
		} catch (SQLException e) {
			fail("SqlException - " + e.getMessage());
		}
	}
}
