package study;

public class SumNumber {

	public static void main(String[] args) {
		int sum = 0;
		int totalSum = 0;
		for (int i = 1; i <= 10; i++) {
			sum = sum + i;
			totalSum = totalSum + sum;
			System.out.println(totalSum);
		}
	}
}
