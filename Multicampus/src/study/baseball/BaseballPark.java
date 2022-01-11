package study.baseball;

import java.util.Scanner;


public class BaseballPark {

	public static void main(String[] args) {
		BaseballPark park = new BaseballPark();
		park.playball();

	}

	public void playball() {
		NumberBaseballGame game = new NumberBaseballGame();
		game.makeHiddenNumber(); // 숨겨진 넘버 생성
		System.out.println("hiddenNumber가 생성되었습니다.");
		System.out.println("hidden Number is " + game);
		System.out.println("숫자야구게임을 시작합니다.");
		Scanner scan = new Scanner(System.in);
	
		while (true) {
			int strike = 0;
			int ball = 0;
			String inputNum = "0000"; // 입력한 데이터
			
			while(true) {
				// 4자리 숫자가 중복숫자가 아닐때까지 계속 요청
				System.out.println("중복되지 않은 4자리수를 입력해주세요");
				System.out.print("입력 [ 게임중단 : 0000] >> ");
				inputNum = scan.next();
				if(inputNum.equals("0000")){ // 중단숫자 0000
					System.out.println("이번 게임을 종료합니다.");
					break;
				}
				boolean flag = game.isSameNumber(inputNum);
				if(!flag) { // 중복이 아니면 빠져나옴
					break;
				}
			}
			
			System.out.println("비교요청: ");
			int[] result =  game.judgeNumber(inputNum);
			
			System.out.println("비교결과: ");
			strike = result[0];
			ball =result[1];
			
			if(/*4strike*/strike==4) {
				System.out.println("게임에서 승리하였습니다.");
				break;
			}
			// 비교결과 사용자에게 알려줌
			System.out.printf("%d strike(s) %d ball(s)", strike, ball);
		}
		scan.close();
	}
}
