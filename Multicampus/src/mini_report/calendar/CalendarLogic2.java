package mini_report.calendar;

public class CalendarLogic2 {
	final int YEAR = 1900;
	final int MONTH = 1;
	final int WEEKDAY = 1; // MONDAY : 빈칸수 1

	private int[] endDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public void printCalendar(int year, int month) {
		if (leafYear(year))
			endDays[1] = 29;

		int space = space(year, month);
		int endDay = endDays[month - 1];
		System.out.printf("====%d년 %d월====\n", year, month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for (int i = 0; i < space; i++)
			System.out.print("\t");

		for (int i = 1; i <= endDay; i++) {
			System.out.print(i + "\t");
			if ((i + space) % 7 == 0 || i == endDay)
				System.out.println();
		}
	}

	private boolean leafYear(int year) {
		if (year % 400 == 0 || year % 100 != 0 && year % 4 == 0)
			return true;
		return false;
	}

	private int space(int year, int month) {
		int lastDay = 0;
		for (int i = YEAR; i < year; i++)
			lastDay += leafYear(i) ? 366 : 365;
		for (int i = MONTH; i < month; i++)
			lastDay += endDays[i - 1];
		
		System.out.println(lastDay);
		System.out.println((lastDay + WEEKDAY) % 7);
		return (lastDay + WEEKDAY) % 7;
	}
}