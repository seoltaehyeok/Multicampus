package lotto;

public class LottoMachine {
	// 공이라는 데이터를 가지고 있어야함
	LottoBall[] balls;
	
	// 공을 집어넣음 (공을 초기화)
	LottoMachine(LottoBall[] balls){
		this.balls = balls;
	}
	
	// 뽑은 공을 스택에 쌓기
	void startMachine() {
		System.out.println("로또 번호를 뽑습니다.");
		for(int i=0; i<7; i++) {
			LottoBall ball = this.getBall();
		}
	}
	
	// 공을 하나씩 뽑기
	LottoBall getBall() {
		LottoBall ball = null;
		System.out.println("로또 공 하나를 선택했습니다.");
		return ball;
	}
}
