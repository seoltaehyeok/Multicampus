package study.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

public class EmpDAO {
	// DAO (Data Access Object)
	// 테이블에 관련된 CRUD 작업을 한다. (DQL, DML)
	public void testInsertV2() throws SQLException {
		String sql = "insert into emp(emp_name, emp_age, emp_hiredate, dept_code) values(?, ?, ?, ?)";
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		// 통로
		PreparedStatement pstmt = con.prepareStatement(sql); // SQL이 준비 되었다.

		pstmt.setString(1, "Park"); // valuse의 첫번째 : emp_name값
		pstmt.setInt(2, 28); // valuse의 두번째 : emp_age값
		Timestamp stamp = new Timestamp(System.currentTimeMillis()); 
		pstmt.setTimestamp(3, stamp); // valuse의 세번째 : emp_hiredate값
		pstmt.setString(4, "ABCDE");	// valuse의 네번째 :dept_code값
		int affectedCount = pstmt.executeUpdate(); // 쿼리를 PreparedStatement에서 보냈으므로 보내지 않음
		if (affectedCount > 0) {
			System.out.println("삽입완료");
		} else {
			System.out.println("삽입실패");
		}
		cm.closeConnection(con, pstmt, null);
	}

	// emp 테이블과 컬럼명이 일치해야함 (db에서 설정)
	// hiredate는 dateTime을 넣어주는 것이므로 하드코딩x 시간객체를 통해 만들어준다. (데이터 무결성) => InsertV2에서
	// 처리
	public void testInsert() throws SQLException {
		String sql = "insert into emp(emp_name, emp_age, emp_hiredate, dept_code) "
				+ "values('Park', 23, '2022-01-20 14:01:20', 'ABCDE')";
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();

		Statement stmt = con.createStatement();
		int affectedCount = stmt.executeUpdate(sql);
		if (affectedCount > 0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}

	public void testConnection() throws SQLException {
		// Mysql에 접속하여 컨넥션 객체가 만들어져서 전달되는지 확인하는 코드
		// 컨넥션 객체는 ConnectionManager 클래스의 getConnection메소드를 호출하여 전달받는다.
		// ConnectionManager 클래스의 패키는 실행클래스와 동일하다.
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		if (con != null) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}

	public void testQuery() throws SQLException {
		String sql = "select * from usertbl";
		ConnectionManager cm = new ConnectionManager();
		// Connection을 가져와야 함 (DB연결)
		Connection con = new ConnectionManager().getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// Query 데이터가 지나갈 수 있도록 통로
			// Statement는 Connection 객체를 통해서 만든다.
			// **new or 다른객체가 아님** => Statement가 db가 직접적으로 어디에 있는지 모르기 때문
			stmt = con.createStatement(); // 통로 오픈
			rs = stmt.executeQuery(sql); // 쿼리를 보내고 받는다.
			// 결과 처리하기
			while (rs.next()) {
				// 해당 테이블의 스키마값이 생각이 안날 때
				System.out.printf("%s %s %s %n", rs.getString(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결 종료하기
			cm.closeConnection(con, stmt, rs);
		}
	}

	public void testQuery2() throws SQLException {
		String sql = "select emp_name, emp_age, emp_hiredate from emp";
		ConnectionManager cm = new ConnectionManager();
		// Connection을 가져와야 함 (DB연결)
		Connection con = new ConnectionManager().getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// Query 데이터가 지나갈 수 있도록 통로
			// Statement는 Connection 객체를 통해서 만든다.
			// **new or 다른객체가 아님** => Statement가 db가 직접적으로 어디에 있는지 모르기 때문
			stmt = con.createStatement(); // 통로 오픈
			rs = stmt.executeQuery(sql); // 쿼리를 보내고 받는다.
			// 결과 처리하기
			while (rs.next()) {
				System.out.printf("%s %s %s %n", rs.getString(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결 종료하기
			cm.closeConnection(con, stmt, rs);
		}
	}

	// ArrayList를 이용하여 DB에 있는 데이터들을 VO에 넣는작업
	public void testQueryWithVO() throws SQLException {
		String sql = "select * from emp";
		// Connection을 가져와야 함 (DB연결)
		Connection con = new ConnectionManager().getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		// ArrayList<EmpVO>를 사용하여 레코드 EmpVO인스턴스를 생성하여 저장하는 코드 작성
		ArrayList<EmpVO> list = new ArrayList<>();
		EmpVO vo = null;

		try {
			// Query 데이터가 지나갈 수 있도록 통로
			// Statement는 Connection 객체를 통해서 만든다.
			// **new or 다른객체가 아님** => Statement가 db가 직접적으로 어디에 있는지 모르기 때문
			stmt = con.createStatement(); // 통로 오픈
			rs = stmt.executeQuery(sql); // 쿼리를 보내고 받는다.
			// 결과 처리하기
			while (rs.next()) {
				int empCode = rs.getInt("emp_code");
				String empName = rs.getString("emp_name");
				int empAge = rs.getInt("emp_age");
				Timestamp empHiredate = rs.getTimestamp("emp_hiredate");
				int empSalary = rs.getInt("emp_salary");
				String deptCode = rs.getString("dept_code");
				vo = new EmpVO(empCode, empName, empAge, empHiredate, empSalary, deptCode);
				list.add(vo);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (EmpVO emp : list) {
			System.out.println(emp);
		}
	}
}
