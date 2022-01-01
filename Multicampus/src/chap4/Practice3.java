package chap4;

public class Practice3 {

	public static void main(String[] args) {
//		int sum = 0;
//		int accumulateSum = 0;
//		for(int i=1; i<=10; i++) {
//			sum = sum + i;
//			accumulateSum = accumulateSum + sum;
//		}
//		System.out.println(accumulateSum);
//	}
		int sum = 0;
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=i; j++) {
				sum = sum + j;
			}
		}
		System.out.println(sum);
	}
}
