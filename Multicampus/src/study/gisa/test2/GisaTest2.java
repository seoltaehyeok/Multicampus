package study.gisa.test2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

// 지역코드가 B인 자료에 대하여 (국어점수 + 영어점수) 중 가장 큰 값을 출력하되,
// 만약 동일 값 발생시는 한번만 출력하시오.
public class GisaTest2 {

	public static void main(String[] args) {
		GisaTest2 gt = new GisaTest2();
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
		String answer2 = this.solveTwo(list);
		this.writeAnswer(answer2, 2);

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
			int kor = Integer.parseInt(line.substring(10, 13).trim());
			int eng = Integer.parseInt(line.substring(13, 16).trim());
			String locCode = line.substring(30,31).trim();
			vo = new GisaDataVO();
			vo.setKor(kor);
			vo.setEng(eng);
			vo.setLocCode(locCode);
			list.add(vo);
		}
		br.close();
		fr.close();

		return list;
	}



	private String solveTwo(ArrayList<GisaDataVO> list) {
		// 해당하는 문제를 해결하는 로직 작성
		String answer = null;
		int max = 0;
		for (GisaDataVO vo : list) {
			// (vo.getLocCode() == "B" 이건 왜 동작을 안할까?
			// 다른 객체의 값 "B"는 다르다고 판단하기 때문에
			if (vo.getLocCode().equals("B")) { 
				int value = vo.getKor() + vo.getEng();
				max = max < value ? value : max;
			}
		}
		answer = String.valueOf(max);
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
