package mimi_report.lotto;

import java.util.ArrayList;

public class StudioExample {

	public static void main(String[] args) {
		StudioExample studio = new StudioExample(); // 객체생성
		studio.onAir();	// 메서드 호출

	}
	
	public void onAir() {	// 메서드
		LottoMachine machine = readyLottoMachine(); // this.readyLottoMachine() 해당 메소드  호출
		System.out.println("지금부터 로또 추첨을 시작합니다.");
		machine.startMachine();
		System.out.println("지금까지 로또 추첨이었습니다.\n감사합니다.");
	}
	
	public LottoMachine readyLottoMachine() { // 메서드
		LottoMachine machine = null;
		machine = new LottoMachine(this.makeBall());
		return machine;
	}
	
	public ArrayList<LottoBall> makeBall() {
		ArrayList<LottoBall> balls = new ArrayList<LottoBall>();
		for(int i=0; i<45; i++) {
			balls.add(new LottoBall(i+1));
		}
		return balls;
	} 
}
