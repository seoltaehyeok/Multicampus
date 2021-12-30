package study;

public class CalendarService {

	public static void main(String[] args) {
		// 2020~2024년의 달력생성 --> 2020년 12월 빈칸정보 2
		int year = 2021;
		int month = 12;
		int[] spaces = new int[12];
		int[] lastDays = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		spaces[0] = (2+31)%7; // spaces[0] = 5 	( 전년도12월 빈칸 수+1월날짜 수 ) % 7 = 1월달 빈칸 수
		for(int i=1;i<12;i++) {
			spaces[i] = (spaces[i-1]+lastDays[i-1])%7; // spaces[1] = 1 (2월달 빈칸 수)
		}
//		for(int i=0;i<12;i++) {
//			System.out.println((i+1)+"/"+spaces[i]); //디버깅용
//		}
		int space = spaces[month-1]; // 1월: 5
		//윤년판단 로직
		int lastDay = lastDays[month-1]; // 1월: 31
		if(year%400==0 || (year%4==0&&year%100!=0)) {
			lastDay = 29;
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
