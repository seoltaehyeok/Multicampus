package mini_report.miniReport;

public class Multiple {

	public static void main(String[] args) {
		Multiple mp = new Multiple();
		mp.horizon();
		mp.verticle();

	}

	// 구구단 가로
	public void horizon() {
		System.out.println("==가로==");
		for(int i=2; i<10; i++) {
			for(int j=1; j<10; j++) {
				System.out.printf("%d*%d=%d\t", i, j, j*i);
			}
			System.out.println();
		}
	}

	// 구구단 세로
	public void verticle() {
		System.out.println("==세로==");
		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				System.out.printf("%d*%d=%d\t", j, i,i * j);
			}
			System.out.println();
		}
	}

}
