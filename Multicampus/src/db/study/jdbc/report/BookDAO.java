package db.study.jdbc.report;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDAO {
	String url = "jdbc:mysql://localhost:3306/shopdb";
	String driver = "com.mysql.cj.jdbc.Driver";
	String id = "root";
	String password = "mcys1309";

	// book 테이블에 데이터 저장
	public void insertBook(BookDTO bookDTO) throws SQLException, ClassNotFoundException {
		/*--------DB Connection-----------*/

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, id, password);

		/* PROGRAM - Table PIPE */
		Statement stmt = con.createStatement();

		/* -----SQL Query ------ */
			StringBuffer sql = new StringBuffer("insert into book values('");
			sql.append(bookDTO.getBookNo() + "', '");
			sql.append(bookDTO.getBookTitle() + "', '");
			sql.append(bookDTO.getBookAuthor() + "', ");
			sql.append(bookDTO.getBookYear() + ", ");
			sql.append(bookDTO.getBookPrice() + ", '");
			sql.append(bookDTO.getBookPublisher()+ "'");
			sql.append(");");

			int affectedCount = stmt.executeUpdate(sql.toString());
			if (affectedCount > 0) {
				System.out.println("데이터 삽입을 실행하였습니다.");
			} else {
				System.out.println("데이터 삽입을 실패하였습니다.");
			}
			stmt.close();
			con.close();
		}

	// book 테이블에 있는 모든 데이터 출력
	public void selectBook() throws SQLException {
		Connection con = DriverManager.getConnection(url, id, password);
		String sql = "select * from book";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			System.out.printf("%s \t" // 잡지번호
					+ "%s\t" // 이름
					+ "%s\t" // 저자
					+ "%d \t" // 발행연도
					+ "%d\t" // 가격
					+ "%s\t\t", // 출판사
					rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
			System.out.println();
		}
		stmt.close();
		con.close();
	}
}
