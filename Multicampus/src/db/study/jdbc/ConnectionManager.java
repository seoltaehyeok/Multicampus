package db.study.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	// Connection 전용으로 만들어 주는 method 작성 (test
	public Connection getConnection() {
		Connection con = null;
		// db connection info
		String url = "jdbc:mysql://localhost:3306/shopdb";
		String driver = "com.mysql.jdbc.Driver"; // 클래스정보
		String id = "";		// DB 아이디입력
		String pwd = ""; // DB 비밀번호

		// Connection - 데이터베이스와 연결하는 객체입니다.
		// DriverManager 클래스는 JDBC 드라이버를 통하여 Connection을 만드는 역할
		try {
			Class.forName(driver); // JVM에게 필요한 것을 전달 (클래스 정보 driver) => 오브젝트생성하는 방법
			con = DriverManager.getConnection(url, id, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}
}
