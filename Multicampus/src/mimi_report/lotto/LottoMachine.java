package mimi_report.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class LottoMachine {
	// 공이라는 데이터를 가지고 있어야함
	ArrayList<LottoBall> balls; // 인스턴스

	// 공을 집어넣음 (공을 초기화)
	LottoMachine(ArrayList<LottoBall> balls) { // 생성자
		this.balls = balls;
	}

	// 뽑은 공을 스택에 쌓기
	void startMachine() { // 메서드
		System.out.println("로또 번호를 뽑습니다.");
		System.out.println();
		Integer[] choiceBalls = new Integer[7];
		int count = 0;

		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LottoBall ball = this.getBall();
			choiceBalls[count] = ball.getBallNumber();
			System.out.printf("뽑힌 공은 %d번 입니다. %n %n", ball.getBallNumber());
			count += 1;

			if (count == 6)
				break;
		}
		
		LottoBall ball = this.getBall();
		choiceBalls[count] = ball.getBallNumber();
		System.out.printf("보너스 당첨번호는 %d번 입니다.%n", ball.getBallNumber());
		System.out.println();
		System.out.printf("추첨된 번호는 %s입니다. %n", Arrays.toString(choiceBalls));
	}

	void shuffle(LottoBall[] balls) {
		Random rand = new Random();
		int idx = rand.nextInt(7);

	}

	// 공을 하나씩 뽑기
	LottoBall getBall() { // 메서드
		LottoBall ball = null;
		Random rand = new Random();
		int idx = rand.nextInt(balls.size());
		ball = balls.remove(idx);
		System.out.println("로또 공 하나를 선택했습니다.");

		return ball;
	}
}
