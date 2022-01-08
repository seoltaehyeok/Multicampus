package mini_report.calendar;

public class AugustCalendar {
// 2021 8 달력
	public static void main(String[] args) {
		AugustCalendar ac = new AugustCalendar();
		ac.print();
	}

	public void print() {
		// space = 0, endDay = 31
		System.out.println("===2021년 8월===");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for (int i = 1; i <= 31; i++) {
			System.out.print(i + "\t");
			if (i % 7 == 0) {
				System.out.println();
			}
		}
	}
}
