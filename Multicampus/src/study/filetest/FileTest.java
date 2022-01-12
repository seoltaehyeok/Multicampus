package study.filetest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// throws Exception : 예외처리를 미룸
// try {} catch {} : 해당 예외를 바로 처리
public class FileTest {

	public static void main(String[] args) {
		FileTest ft = new FileTest();
		try {
			ft.testFileReaderCopy();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없음 : 메인에서 처리");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public void test() {
//		// 파일 인스턴스 생성
//		File file = new File("data/Abc1115.txt");
//
//		if (file.exists()) {
//			System.out.printf("file name is %s %n", file.getName());
//			System.out.printf("file size is %d bytes %n", file.length());
//		} else {
//			System.out.println("file is not exists!");
//		}
//	}

//	public void testFileReader() throws FileNotFoundException, IOException {
//		// Abc1115.txt에 연결하는 File 인스턴스 생성하시오
//		File file = new File("./data/Abc1115.txt");
//		FileReader fr = new FileReader(file); // 파일 읽기
//		BufferedReader br = new BufferedReader(fr); // 파일 내용 읽기
//		String line = null;
//		while ((line = br.readLine()) != null) {
//			System.out.println(line);
//		}
//		// 가장 나중에 열린 것이 가장 먼저 닫힘
//		br.close();
//		fr.close();
//	}

	public void testFileReaderCopy() throws FileNotFoundException, IOException {
		// Abc1115.txt에 연결하는 File 인스턴스 생성하시오
		File file = new File("./data/Abc1115.txt");
		File destFile = new File("./data/test.txt");

		FileReader fr = new FileReader(file); // 싱커스트림 (연속적인 데이터의 흐름 =>한줄띄우는것을 처리하지 않음)
		BufferedReader br = new BufferedReader(fr); // 링커스트림  - FileReader의 한줄처리(br.readLine()) 를 위해 (파일에 인식을 할 수 없음)
		FileWriter fw = new FileWriter(destFile); // 생성된 파일을 참조하는 참조변수 fw생성
		PrintWriter pw = new PrintWriter(fw); // 파일(fw)에 쓰기 위한 참조변수 pw생성

		String line = null;
		while ((line = br.readLine()) != null) { // 라인 1줄을 읽어서 line에 저장 -> line이 null 이 아니면 true (반복문 돌기)
			System.out.println(line);				// console에 해당 라인 1줄 출력
			pw.println(line);								// 해당 파일에 라인 1줄 출력(PrintWriter pw)  
		}															// 반복문을 통한 pw.print(line)으로 인해 해당 라인의 문자를 계속 누적
		
		// 가장 나중에 열린 것이 가장 먼저 닫힘
		br.close(); // 나중에 생성된 입력
		fr.close(); // 먼저 생성된 입력
		pw.close(); // 나중에 생성된 출력
		fw.close(); // 먼저 생성된 출력
	}

//	public void testFileReader2() {
//		// Abc1115.txt에 연결하는 File 인스턴스 생성하시오
//		File file = new File("data/Abc1116.txt");
//		try {
//			FileReader fr = new FileReader(file);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("해당 파일을 찾을 수 없습니다.");
//		}
//
//	}

}
