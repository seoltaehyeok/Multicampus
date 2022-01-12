package study.filetest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class FileExam {

	public static void main(String[] args) {
		FileExam fe = new FileExam();
		try {
			fe.createFile();
		} catch (FileNotFoundException e) {
			// 파일을 찾을 수 없을 경우 예외처리
			System.out.println("해당 파일을 찾을 수 없음");
		} catch (IOException e) {
			// 입출력 예외처리
		}
	}

	// 파일 생성하기
	public void createFile() throws FileNotFoundException, IOException {
		File file = new File("filetest/test.txt");

		if (file.exists()) {
			System.out.println(file.getName() + "파일이  존재합니다.");
			FileReader fr = new FileReader(file); // 해당 파일을 찾아보고 없을 경우 예외처리
			BufferedReader br = new BufferedReader(fr);

			Stream<String> lines = br.lines();
			lines.forEach(System.out::println);

			br.close();
			fr.close();
		} else {
			System.out.println("파일이 존재하지 않습니다.");
			System.out.println("파일을 생성합니다.");
			file.createNewFile();
		}
	}
}
