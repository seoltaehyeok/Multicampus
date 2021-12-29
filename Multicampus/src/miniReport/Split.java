package miniReport;

public class Split {

	public static void main(String[] args) {
		// int형의 경우 2147483647을 초과하면 값을 인식x
		int number = 2147483647;
		
		do {
			System.out.println(number % 10);
			number = number / 10;
		} while(number!=0);
	}

}
