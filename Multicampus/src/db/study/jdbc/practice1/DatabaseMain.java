package study.db.jdbc;

import java.sql.SQLException;

public class DatabaseMain {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DatabaseMain dm = new DatabaseMain();
		dm.testCRUD();
	}
	
	public void testCRUD() throws SQLException {
		EmpDAO dao = new EmpDAO();
		dao.testQueryWithVO();
//		try {
//			dao.testQuery2();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
	}
}
