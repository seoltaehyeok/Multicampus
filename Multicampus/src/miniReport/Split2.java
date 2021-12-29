package miniReport;

public class Split2 {

	public static void main(String[] args) {
		// int형의 경우 2147483647을 초과하면 값을 인식x
		String number = "2147483647";
		int length = number.length();
		int num = Integer.parseInt(number);
		for(int i=0; i<length; i++) {
			System.out.println(num % 10);
			num = num / 10;
		}
	}
}
