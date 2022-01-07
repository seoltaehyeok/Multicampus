package study;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestCalendarTime {

	public static void main(String[] args) {
		TestCalendarTime ct = new TestCalendarTime();
		ct.testCalendar();

	}
	
	public void testCalendar() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yy.MM.dd hh:mm:ss(EEE)");
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		// int day = cal.get(Calendar.DATE); 같은 의미
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		System.out.printf("year: %d, month: %d, day: %d, hour: %d, min: %d, sec: %d, week: %d", year, month, day, hour, min, sec, week);
		System.out.println();
		String now = df.format(new Date());
		System.out.println(now);
	}
}
