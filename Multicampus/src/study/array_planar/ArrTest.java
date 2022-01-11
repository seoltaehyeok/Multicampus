package study.array_planar;


public class ArrTest {

	public static void main(String[] args) {
		String studentKim = "kim,39,49,59";
		String studentLee = "lee,48,89,64";
		String studentPark = "park,90,81,100";
		
		String[] scores = { studentKim, studentLee, studentPark };
		
		for(int i=0; i<scores.length; i++) {
			String[] temp = scores[i].split(",");
			int kor =0, eng=0, math=0;
			String name = temp[0];
			
			
			
			
			kor = Integer.parseInt(temp[1].trim());
			eng = Integer.parseInt(temp[2].trim());
			math = Integer.parseInt(temp[3].trim());
			
			int sum = kor + eng + math;
			double avg = sum / 3;
			Data result = new Data(name, kor, eng, math);
			System.out.println(result);
			System.out.printf("%s 의 성적: 국어: %d, 영어: %d, 수학: %d, [ 총합: %d , 평균: %.2f ]\n", name, kor, eng, math, sum, avg);
		}

	}

}
