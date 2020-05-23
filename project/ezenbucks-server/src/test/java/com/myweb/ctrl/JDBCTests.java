package com.myweb.ctrl;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCTests {
	private static Logger log = LoggerFactory.getLogger(JDBCTests.class);
	static {
		try {
			Class.forName("mysql.jdbc.driver.MysqlDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {

		try (Connection con = DriverManager.getConnection(
				"jdbc:log4jdbc:mysql://localhost:3306/ezenbucks", "ezen",
				"asdf1234")) {

			log.info(">>> JDBC TEST >>> "+con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
