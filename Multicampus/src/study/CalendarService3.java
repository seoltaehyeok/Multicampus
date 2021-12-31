package study;

import java.util.Scanner;

public class CalendarService3 {

	public static void main(String[] args) {
		CalendarService3 cm = new CalendarService3();
		cm.print();
	}

	public void print() {
		Scanner sc = new Scanner(System.in);
		boolean flag = false;

		while (!flag) {
			System.out.print("input month: ");
			int month = sc.nextInt();

			makeCalendar(month);

			System.out.print("계속하시겠습니까? [yes:1 / no:0]");
			month = sc.nextInt();
			if (month == 0) {
				System.out.println("종료되었습니다.");
				flag = true;
			}
		}
		sc.close();
	}

	void makeCalendar(int mon) {
		
		int year = 2021;
		int month = mon;
		int spaceVal = 2;

		int[] spaces = new int[12];
		int[] lastDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		// (지난 달 빈칸 수 + 이번 월 날짜수) % 7 = 이번 달 빈칸 수
		for (int i = 0; i < 12; i++) {
			spaces[i] = (lastDays[i] + spaceVal) % 7;
			spaceVal = spaces[i];
		}
		
//		수정 전
//		int space = spaces[month - 1];
//		int lastDay = lastDays[month - 1];
//		
//
//		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
//			lastDay = 29;
//		}

		// 수정 후
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			lastDays[1] = 29;
		}
		
		int space = spaces[month - 1];
		int lastDay = lastDays[month - 1];

		System.out.printf("%d년 %d월\n", year, month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for (int i = 0; i < space; i++) {
			System.out.print("\t");
		}
		int day = 1;
		for (int i = 0; i < lastDay; i++) {
			System.out.print(day + "\t");
			if ((space + day) % 7 == 0) {
				System.out.println();
			}
			day = day + 1;
		}
		System.out.println("\n");
	}
}
