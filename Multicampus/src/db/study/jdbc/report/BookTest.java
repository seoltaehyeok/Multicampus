package db.study.jdbc.report;

import java.sql.SQLException;

public class BookTest {

	public static void main(String[] args) {
		BookDTO list = new BookDTO("B004", "자바스크립트", "강길동", 2020, 28000, "서울출판사");
		
		BookDAO dao = new BookDAO();
		
		
			try {
				dao.insertBook(list);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println("Class Not Found");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


		try {
			dao.selectBook();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
