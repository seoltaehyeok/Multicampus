package mini_report.Calendar;

public class CalendarLogic1 {
// 2021년도 달력
	public static void main(String[] args) {
		CalendarLogic1 cl1 = new CalendarLogic1();
		int month = 12;
		cl1.print(month);
	}
	
	public void print(int month) {
		int[] spaces = new int[12];
		int[] endDays = {31,28,31,30,31,30,31,31,30,31,30,31};
		spaces[0] = (2+31) % 7;
		
		for(int i=1; i<12; i++) {
			spaces[i] = (spaces[i-1]+endDays[i-1]) %7;
		}
		int space = spaces[month-1];
		int endDay = endDays[month-1];
		
		System.out.printf("====21년 %d월====\n", month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for(int i=0; i<space; i++)
			System.out.print("\t");
		for(int i=1; i<=endDay; i++) {
			System.out.print(i+"\t");
			if((i+space)%7==0){
				System.out.println();
			}
		}
	}
}
