package chap4;

public class Practice6 {

	public static void main(String[] args) {
		int cnt = 0;
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; j++) {
				if (i + j == 6) {
					System.out.printf("%d + %d = %d\n", i, j, i + j);
					cnt++;
				}
			}	
		}
		System.out.println("모든 경우의 수: "+ cnt);
	}
}
