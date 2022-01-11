package study.array_planar;

public class School {

	public static void main(String[] args) {
		School school = new School();
		school.test1();
	}

	public void test1() {
		String studentKim = "kim,39,49,59";
		String studentLee = "lee,48,89,64";
		String studentPark = "park,90,81,100";

		String[] scores = { studentKim, studentLee, studentPark };
		// StudentVO[] students = new StudentVO[scores.length];

		for (int i = 0; i < scores.length; i++) {
			String[] temp = scores[i].split(","); // [0]=>  "kim,39,49,59" (4개) / [1]=>"lee,48,89,64" (4개) ..
			int kor = 0, eng = 0, math = 0;
			String name = temp[0];
			try {
				kor = Integer.parseInt(temp[1].trim());
				eng = Integer.parseInt(temp[2].trim());
				math = Integer.parseInt(temp[3].trim());
			} catch (NumberFormatException nfe) {
				System.out.println(nfe.getMessage());
				System.out.println();
			}
			StudentVO result = new StudentVO(name, kor, eng, math);
			System.out.println(result);
			int total = result.getTotal();
			double avg = result.getAvg();
			System.out.printf("%s의 성적: [total : %d점 avg : %.2f점]\n", name, total, avg);
		}
	}
}
