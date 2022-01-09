package mini_report.calendar;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarClass {

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		CalendarClass cc = new CalendarClass();

		boolean finish = false;

		while (!finish) {
			System.out.print("구하고자 하는 년도를 입력하세요: ");
			int year = sn.nextInt();
			System.out.print("구하고자 하는 월을 입력하세요: ");
			int month = sn.nextInt();
			cc.printCalendar(year, month);

			System.out.println("그만 하시겠습니까? Y/N");
			char tf = sn.next().charAt(0);
			if (tf == 'y' || tf == 'Y') {
				System.out.println("종료되었습니다.");
				finish = true;
			}
		}

	}

	void printCalendar(int year, int month) {
		Calendar cd = Calendar.getInstance();
		cd.set(year, month - 1, 1);

		int space = cd.get(Calendar.DAY_OF_WEEK) - 1;
		int lastDay = cd.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.printf("\t==%d년 %2d월==\t\n", year, month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for (int i = 0; i < space; i++)
			System.out.print("\t");
		for (int i = 1; i <= lastDay; i++) {
			System.out.print(i + "\t");
			if ((space + i) % 7 == 0 || i == lastDay)
				System.out.println();
		}
	}

}
