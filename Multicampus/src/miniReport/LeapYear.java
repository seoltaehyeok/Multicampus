package miniReport;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("해당년도를 입력하세요: ");
		
		int year = in.nextInt();
		
		if(year%4==0 && year%100!=0 || year%400==0) {
			System.out.println("해당년도는 윤년입니다.");
		}
		else
			System.out.println("해당년도는 윤년이 아닙니다.");
	}
}
