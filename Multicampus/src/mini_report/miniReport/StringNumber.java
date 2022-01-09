package mini_report.miniReport;

import java.util.Scanner;

public class StringNumber {

	public static void main(String[] args) {
		StringNumber sn = new StringNumber();
		Scanner in = new Scanner(System.in);
		System.out.print("logic1 의 number: ");
		String number1 = in.nextLine();
		sn.NumberLogic1(number1);
		System.out.print("logic2 의 number: ");
		String number2 = in.nextLine();
		sn.NumberLogic2(number1);
		System.out.print("logic3 의 number: ");
		String number3 = in.nextLine();
		sn.NumberLogic3(number1);
	}

	public void NumberLogic1(String num) {
		int sum = 0;
		for (int i = 0; i < num.length(); i++) {
			int number = num.charAt(i) - '0';
			sum += number;
		}
		System.out.println(sum);
	}

	public void NumberLogic2(String num) {
		int sum = 0;
		String[] number = num.split("");
		for (int i = 0; i < num.length(); i++) {
			sum += Integer.parseInt(number[i]);
		}
		System.out.println(sum);
	}

	public void NumberLogic3(String num) {
		int sum = 0;
		for (int i = 0; i < num.length(); i++) {
			char val = num.charAt(i);
			String number = String.valueOf(val);
			sum += Integer.parseInt(number);
		}
		System.out.println(sum);
	}
}
