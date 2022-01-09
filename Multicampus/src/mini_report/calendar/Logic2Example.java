package mini_report.calendar;

import java.util.Scanner;

//만년달력 만들기
public class Logic2Example {

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		CalendarLogic2 logic = new CalendarLogic2();
		boolean finish = false;

		while (!finish) {
			System.out.print("구하고자 하는 년도를 입력하세요: ");
			int year = sn.nextInt();
			System.out.print("구하고자 하는 월을 입력하세요: ");
			int month = sn.nextInt();
			logic.printCalendar(year, month);
			System.out.println("계속하시겠습니까? Y/N");
			char tf = sn.next().charAt(0);
			if (tf != 'y' && tf != 'Y') {
				System.out.println("종료되었습니다.");
				finish = true;
			}

		}
	}
}
