package study;

import java.util.Date;

public class TestDateTime {

	public static void main(String[] args) {
		TestDateTime datetime = new TestDateTime();
		datetime.testDate();
		String now = new DateService().getDateInfo(DateService.FULL_INFO);
		System.out.println();
		System.out.println(now);
	}

	// date.get함수는 현재 사용하지 않음
	public void testDate() {
		// Date 클래스 사용
		Date date = new Date();
		int year = date.getYear() + 1900;
		int month = date.getMonth() + 1;
		int day = date.getDate();

		int hour = date.getHours();
		int min = date.getMinutes();
		int sec = date.getSeconds();
		System.out.printf("year: %d, month: %d, day: %d, hour: %d, min: %d, sec: %d", year, month, day, hour, min, sec);
	}
}
