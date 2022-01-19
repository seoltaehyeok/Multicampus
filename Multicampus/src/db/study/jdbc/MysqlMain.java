package db.study.jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MysqlMain {

	public static void main(String[] args) throws SQLException {
		MysqlMain mm = new MysqlMain();
		mm.insertTest();
//		mm.deleteTest();
//		mm.insertData(null); 값이 null 일경우 insertData 메소드에서 nullpointException을 발생할 수 있다.

//		try {
//			mm.test();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("해당 파일이 없어 DB작업 불가능합니다. " + e.getMessage());
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("정상 종료합니다.");
	}

	public void deleteTest() {
		try {
			this.deleteData(new int[] { 990001, 990011 });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertTest() throws SQLException {
		// 한 줄의 데이터를 생성할 것이다.
		// readyData를 호출해서 1000개의 데이터를 가진 list를 가지고 오는 코드 작성
		ArrayList<GisaDataVO> list = null;
		try {
			list = readyData();
//			this.insertData(list.get(10));
			this.insertData(list);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private ArrayList<GisaDataVO> readyData() throws FileNotFoundException, IOException {
		ArrayList<GisaDataVO> list = new ArrayList<GisaDataVO>();
		// 파일의 1000라인의 정보를 GisaDataVO를 이용하여 인스턴스로 만들고 ArrayList에 저장
		// 파일에 접속해서 스트림에 연결
		File file = new File("./data/Abc1115.txt");
		FileReader fr = new FileReader(file);
		// 한줄씩 읽기
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		GisaDataVO vo = null;
		while ((line = br.readLine()) != null) {
			// 한줄을 분석해서
			int stdNo = Integer.parseInt(line.substring(0, 6));
			String email = line.substring(6, 10);
			int kor = Integer.parseInt(line.substring(10, 13).trim());
			int eng = Integer.parseInt(line.substring(13, 16).trim());
			int math = Integer.parseInt(line.substring(16, 19).trim());
			int sci = Integer.parseInt(line.substring(19, 22).trim());
			int hist = Integer.parseInt(line.substring(22, 25).trim());
			int total = Integer.parseInt(line.substring(25, 28).trim());
			String mgrCode = line.substring(28, 29);
			String accCode = line.substring(29, 30);
			String locCode = line.substring(30, 31);
			// VO객체에 할당하고
			vo = new GisaDataVO();
			vo.setStdNo(stdNo);
			vo.setEmail(email);
			vo.setKor(kor);
			vo.setEng(eng);
			vo.setMath(math);
			vo.setScience(sci);
			vo.setHistory(hist);
			vo.setTotal(total);
			vo.setMgrCode(mgrCode);
			vo.setAccCode(accCode);
			vo.setLocCode(locCode);
			// 리스트에 저장(리스트는 이미 존재해야 함)
			list.add(vo);
		}
		br.close();
		fr.close();
		return list;
	}

//	************INSERT FOR문 사용안하고 하나의 데이터만 넣어주기 [이거먼저 해보기]*************
	// 자바 -> db로 정보 날리기 ( 1. 쿼리만들기: sql이 필요 )
//	public void insertData(GisaDataVO vo) throws SQLException {
//		// StringBuffer와 StringBuilder를 사용해서 입력 값 11개를 넣어준다. (지속적으로 원하는 문자열을 만들어내기)
//		StringBuffer sql = new StringBuffer("insert into gisaTBL values(");
//		// 데이터를 입력할 때 sql에서는 데이터를 'A' , 'B' 로 표시하므로 ' 를 넣어주어야 한다.
//		sql.append(vo.getStdNo()+", '");
//		sql.append(vo.getEmail()+"', ");
//		sql.append(vo.getKor()+", ");
//		sql.append(vo.getEng()+", ");
//		sql.append(vo.getMath()+", ");
//		sql.append(vo.getScience()+", ");
//		sql.append(vo.getHistory()+", ");
//		sql.append(vo.getTotal()+", '");
//		sql.append(vo.getMgrCode()+"' , '");
//		sql.append(vo.getAccCode()+"' , '");
//		sql.append(vo.getLocCode()+"' ");
//		sql.append(");");
//		System.out.println(sql.toString());
//		
//		
//		/*-------------------------------------
//		 * 프로그램 | DB[table]
//		 * 프로그램과 DB와 연결 : ConnectionManager Class에서 처리
//		 * 프로그램과 table과 연결 : Statement로 처리
//		 * 프로그램 -> table로 쿼리를 보냄 ( INSERT를 수행 :  stmt.executeUpdate(sql.toString()); )
//		 * table로 부터 쿼리의 결과를 리턴받음 (INSERT를 통해 변경된 레코드가 몇 개인지 int형 자료로 보냄
//		 * 통로를 닫음 - stmt.close(); / connection을 닫음 - con.close(); 
//		 * DML: 테이블에 영향을 주는 것을 의미
//		 * 1. 통로연결 / 2. 쿼리 보냄 & 결과 리턴 / 3. 통로 닫음 & 연결 닫음
//		 -------------------------------------*/
//		ConnectionManager cm = new ConnectionManager();
//		Connection con = cm.getConnection(); // 커넥션 생성 = > DB까지 연결통로 생성
//		
//		// 쿼리가 지나가는 통로 만들기 statement 클래스
//		Statement stmt = con.createStatement(); // import java.sql 
//		int affectedCount = stmt.executeUpdate(sql.toString()); // 테이블로부터 데이터를 받음
//		if(affectedCount>0) {
//			System.out.println("삽입 작업 완료.");
//		} else {
//			System.out.println("삽입 작업 실패.");
//		}
//		stmt.close();
//		con.close();
//	}
	
	
//	********************INSERT FOR문 사용하여 1000개의 기사 데이터 값 넣어주기***********************
	public void insertData(ArrayList<GisaDataVO> list) throws SQLException {
		// StringBuffer와 StringBuilder를 사용해서 입력 값 11개를 넣어준다. (지속적으로 원하는 문자열을 만들어내기)

		// ----한번만 수행해야 하므로 for문 밖으로 이동----
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection(); // 커넥션 생성 = > DB까지 연결통로 생성
		// 쿼리가 지나가는 통로 만들기 statement 클래스
		Statement stmt = con.createStatement(); // import java.sql
		// --------------------------------------
		for (GisaDataVO vo : list) {
			StringBuffer sql = new StringBuffer("insert into gisaTBL values(");
			// 데이터를 입력할 때 sql에서는 데이터를 'A' , 'B' 로 표시하므로 ' 를 넣어주어야 한다.
			sql.append(vo.getStdNo() + ", '");
			sql.append(vo.getEmail() + "', ");
			sql.append(vo.getKor() + ", ");
			sql.append(vo.getEng() + ", ");
			sql.append(vo.getMath() + ", ");
			sql.append(vo.getScience() + ", ");
			sql.append(vo.getHistory() + ", ");
			sql.append(vo.getTotal() + ", '");
			sql.append(vo.getMgrCode() + "' , '");
			sql.append(vo.getAccCode() + "' , '");
			sql.append(vo.getLocCode() + "' ");
			sql.append(");");
			System.out.println(sql.toString());
			
			int affectedCount = stmt.executeUpdate(sql.toString()); // 테이블로부터 데이터를 받음
			if (affectedCount > 0) {
				System.out.println("삽입 작업 완료.");
			} else {
				System.out.println("삽입 작업 실패.");
			}
		}
		// ----한번만 수행해야 하므로 for문 밖으로 이동----
		stmt.close();
		con.close();
		
	}

	public void deleteData(int[] stdNo) throws SQLException {
		// 1. sql작성 5. 쿼리결과 평가 6. 작업성공여부확인 7. 연결종료
		String sql = "delete from gisaTBL where std_no = " + stdNo[0];
		// 2. Connection con 획득
		Connection con = new ConnectionManager().getConnection();
		// 3. statement 생성
		Statement stmt = con.createStatement();
		// 4. 쿼리전송
		int affectedCount = stmt.executeUpdate(sql);
		// 5. 쿼리결과 평가
		if (affectedCount > 0) {
			// 6. 작업성공여부확인
			System.out.println("삭제 작업 완료");
		} else {
			System.out.println("삭제 작업 실패");
		}

		// 7. 연결종료
		stmt.close();
		con.close();
	}


	/* ------------------------------------------------------- 
	 * Program과 DataBase의 연결은 ConnectionManager 클래스에서 다룸
	public void test() throws SQLException, ClassNotFoundException {
		// db connection info
		String url = "jdbc:mysql://localhost:3306/shopdb";
		String driver = "com.mysql.jdbc.Driver"; // 클래스정보
		String id = "root";
		String pwd = "kk8691";

		Class.forName(driver); // JVM에게 필요한 것을 전달 (클래스 정보 driver) => 오브젝트생성하는 방법
		Connection con = DriverManager.getConnection(url, id, pwd);
		// Connection - 데이터베이스와 연결하는 객체입니다.
		// DriverManager 클래스는 JDBC 드라이버를 통하여 Connection을 만드는 역할

		if (con != null) {
			System.out.println("connected");
			con.close();
		} else {
			System.out.println("faile connection");
		}
	}
	----------------------------------------------------------*/
}
