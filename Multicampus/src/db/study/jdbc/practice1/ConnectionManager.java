package study.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {

	public Connection getConnection() throws SQLException {
		Connection con = null;
		// mysql에 접속해서 커넥션 객체를 만드는 코드 작성
		String url = "jdbc:mysql://localhost:3306/shopdb";
		String driver = "com.mysql.cj.jdbc.Driver";
		String id = "root";
		String password = "{비밀번호입력}";

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, password);
		} catch (ClassNotFoundException e) {
			System.out.println("해당 클래스를 찾지 못했습니다.");
		} catch (SQLException e) {
			System.out.println("Connection을 만들 수 없습니다.");
		}
		return con;

	}

	public void closeConnection(Connection con, Statement stmt, ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
