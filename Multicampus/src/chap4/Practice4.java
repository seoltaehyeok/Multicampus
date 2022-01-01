package chap4;

public class Practice4 {

	public static void main(String[] args) {
		int num = 1;
		int sum = 0;

		while (true) {
			int temp = 1;
			if (num % 2 == 0) 
				temp = -1;
			
			sum = sum + num * temp;
			if (sum >= 100) 
				break;
			
			num++;
		}
		System.out.printf("num = %d sum = %d\n", num, sum);
	}
}
