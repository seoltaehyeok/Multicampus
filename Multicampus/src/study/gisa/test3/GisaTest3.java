package study.gisa.test3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

// 담임코드에 따른 점수포인트 표를 확인하고,
// 영어 + 수학점수가 120점 이상인 자료의 (총점 + 점수포인트)를 출력하시오.
public class GisaTest3 {

	public static void main(String[] args) {
		GisaTest3 gt = new GisaTest3();
		try {
			gt.testStart();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("파일에 손상이 있는 것 같습니다.");
		}
	}

	public void testStart() throws FileNotFoundException, IOException {
		// 데이터준비 (file의 데이터를 ArrayList로 만들어서 준비)
		ArrayList<GisaDataVO> list = this.readyData();
		// 문제풀이
		String answer3 = this.solveThree(list);
		this.writeAnswer(answer3, 3);

	}

	private ArrayList<GisaDataVO> readyData() throws FileNotFoundException, IOException {
		// 파일의 1000라인의 정보를 GisaDataVO를 이용하여 인스턴스로 만들고 ArrayList에 저장
		ArrayList<GisaDataVO> list = new ArrayList<GisaDataVO>();

		File file = new File("./data/Abc1115.txt");
		FileReader fr = new FileReader(file);

		BufferedReader br = new BufferedReader(fr);
		String line = null;
		GisaDataVO vo = null;

		while ((line = br.readLine()) != null) {

			int eng = Integer.parseInt(line.substring(13, 16).trim());
			int math = Integer.parseInt(line.substring(16, 19).trim());
			int total = Integer.parseInt(line.substring(22, 25).trim());
			String mgrCode = line.substring(28, 29).trim();
			vo = new GisaDataVO();
			vo.setMath(math);
			vo.setEng(eng);
			vo.setTotal(total);
			vo.setMgrCode(mgrCode);
			list.add(vo);
		}
		br.close();
		fr.close();

		return list;
	}

	private String solveThree(ArrayList<GisaDataVO> list) {
		// 해당하는 문제를 해결하는 로직 작성
		String answer = null;
		int sum = 0;

		for (GisaDataVO vo : list) {
			int point = 20;
			if (vo.getMath() + vo.getEng() >= 120) {
				if (vo.getMgrCode().equals("A")) {
					point = 5;
				} else if (vo.getMgrCode().equals("B")) {
					point = 15;
				}
				int total = vo.getTotal() + point;
				sum = sum + total;
			}
			answer = String.valueOf(sum);
		}
		return answer;
	}

	private void writeAnswer(String answer, int order) throws IOException {
		// 해당하는 정답을 파일에 작성한다.
		String filePath = "./data/Ans" + order + ".txt"; // 목적지 파일 참조변수
		File file = new File(filePath); // 파일 객체 생성
		FileWriter fw = new FileWriter(file); // 파일쓰기 객체 생성 (파일이 존재하지 않으면 파일생성)
		PrintWriter pw = new PrintWriter(fw);
		pw.print(answer);
		pw.close();
		fw.close();
	}

}
