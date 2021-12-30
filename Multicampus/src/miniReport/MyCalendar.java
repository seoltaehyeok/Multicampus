package miniReport;


import java.util.Calendar;
import java.util.Scanner;

public class MyCalendar {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		while(true) {
			System.out.print("년도를 입력해주세요: ");
			String inputYear = in.nextLine();
			int year = Integer.parseInt(inputYear);
			
			if(year < 2020 || year > 2024) {
				System.out.println("년도를 잘못 입력하였습니다.");
				continue;
			}
			
			System.out.print("월을 입력해주세요: ");
			String inputMonth = in.nextLine();
			
			if(inputMonth == "") {// 월을 입력하지 않았으므로 해당년도 1~12월 달력 출력
				for(int i=1; i<=12; i++) {
					CalandarPrint(year, i);
				}
				
				System.out.println("그만하시겠습니까? (Y/N)");
				
//				char tf = in.next().charAt(0); // 이렇게 사용하면 Error
				char tf = in.nextLine().charAt(0);
				if(tf == 'Y' || tf == 'y') {
					break;
				}
				else {
					tf = ' ';
					continue;
				}
			}
			
			else {
				int month = Integer.parseInt(inputMonth); // 월을 입력했다면 정수로 변환
				CalandarPrint(year, month);
				
				System.out.println("그만하시겠습니까? (Y/N)");
//				char tf = in.next().charAt(0); // 이렇게 사용하면 Error
				char tf = in.nextLine().charAt(0);
				if(tf == 'Y' || tf == 'y') {
					break;
				}
				else
					continue;
			}
		}
		System.out.println("종료되었습니다.");
	}
	
	public static void CalandarPrint(int year, int month) {
		// Calendar는 추상클래스이므로 객체직접생성x => 클래스의 인스턴스를 얻어야 한다.
		Calendar cal = Calendar.getInstance();
		
		// 입력받은 년도와 월로 세팅
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(year, month-1, 1); // 해당 년 월의 1일로 세팅
		
		System.out.printf("==================[%d년  %d월]====================\n", year, month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		
		int endDate = cal.getActualMaximum(Calendar.DATE);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		for(int i=1; i<dayOfWeek; i++) {
			System.out.print("\t");
		}
		for(int i=1; i<=endDate; i++) {
			System.out.print(i+"\t");
			if(dayOfWeek%7 == 0 || i == endDate) {
				System.out.println();
			}
			
			dayOfWeek++;
		}
		System.out.println("===================================================");
		System.out.println();

	}
}
