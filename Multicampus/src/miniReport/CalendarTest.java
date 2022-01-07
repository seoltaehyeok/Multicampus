package miniReport;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarTest {

	public static void main(String[] args) {
		CalendarTest rc = new CalendarTest();
		Scanner sn = new Scanner(System.in);
		System.out.print("년도를 입력: ");
		int year = sn.nextInt();
		System.out.print("월을 입력: ");
		int month = sn.nextInt();

		// 1~12월 데이터 전달코드 추가
		rc.viewMonthFinalVersion(year, month);
		sn.close();
	}

	void viewMonthFinalVersion(int year, int month) {
		// 빈칸정보 + 마지막날짜 정보를 spaces, lastDays 배열변수에 할당
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		
		int space = cal.get(Calendar.DAY_OF_WEEK)-1;
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.printf("%d년 %d월\n", year, month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		int day = 1;
		for(int i=0; i<space; i++) {
			System.out.print("\t");
		}
		for (int i = 0; i < lastDay; i++) {
			System.out.print(day + "\t");
			if ((space + day) % 7 == 0) {
				System.out.println();
			}
			day = day + 1;
		}
	}
}