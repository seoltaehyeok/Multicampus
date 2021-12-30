package study;

public class CalendarService2 {

	public static void main(String[] args) {
		// 2020~2024년의 달력생성 --> 2020년 12월 빈칸정보 2
		int year = 2021;
		int month = 12;
		int spaceVal = 2;
		int[] spaces = new int[12];
		int[] lastDays = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		
		for(int i=0;i<12;i++) {
			spaces[i] = (lastDays[i]+spaceVal)%7;
			spaceVal = spaces[i];
		}

		int space = spaces[month-1]; // 1월: 5
		int lastDay = lastDays[month-1]; // 1월: 31
		if(year%400==0 || (year%4==0&&year%100!=0)) {
			lastDays[1] = 29;
		} 
		
		System.out.printf("%d년 %d월 %n",year,month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for(int i=0;i<space;i++) {
			System.out.print("\t");
		}
		int day = 1;
		//    
		for(int i=0;i<lastDay;i++) { 
			System.out.print(day+"\t");
			if((space+day)%7==0) {
				System.out.println();
			}
			day = day + 1;
		}
	}
}
