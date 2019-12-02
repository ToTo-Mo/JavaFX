package TestServer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBmanager {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	// mysql connector/j 8.x 버전에서는 url에
	// ?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC 추가해줘야
	// 한다.
	private static final String DB_ADDRESS = "jdbc:mysql://localhost/test?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	private static final String DB_ID = "tejava";
	private static final String DB_PW = "1q2w3e4r!";
	Connection conn = null;
	Statement stmt = null;

	public void startDB() throws ClassNotFoundException {
		try {
			conn = DriverManager.getConnection(DB_ADDRESS, DB_ID, DB_PW);
			System.out.println("\n- MySQL Connection");
			stmt = (Statement) conn.createStatement();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public int studentLogin(String ID, String PW) throws SQLException {
		String sql = "Select max(id) from Student Where id=" + ID + "&& passwd=" + PW + ";";
		if (stmt.executeQuery(sql) == null)
			return 2; // 로그인 실패
		else
			return 1; // 로그인 성공
	}

	public int managerLogin(String ID, String PW) throws SQLException {
		String sql = "Select max(id) from Manager Where id=" + ID + "&& passwd=" + PW + ";";
		if (stmt.executeQuery(sql) == null)
			return 2; // 로그인 실패
		else
			return 1; // 로그인 성공
	}
}
