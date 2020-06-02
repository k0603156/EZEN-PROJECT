package com.myweb.ctrl;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCMysqlTest {
	private static Logger log = LoggerFactory.getLogger(JDBCMysqlTest.class);
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {

		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/ezenbucks?" +
                        "user=ezen&password=asdf1234")) {

			log.info(">>> JDBC TEST >>> "+con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
