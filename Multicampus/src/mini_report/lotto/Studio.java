package mini_report.lotto;

import java.util.ArrayList;

public class Studio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Studio studio = new Studio();
		studio.onAir();
	}
	
	public void onAir() {
		LottoMachine machine = this.readyLottoMachine();
		System.out.println("지금부터 로또 추첨을 시작합니다.");
		machine.startMachine();
		System.out.println("지금까지 로또 추첨이었습니다.\n감사합니다.");
	}
	
	public LottoMachine readyLottoMachine() {
		LottoMachine machine = null;
		machine = new LottoMachine(this.makeBall());
		return machine;		
	}
	
	public ArrayList<LottoBall> makeBall() {
		ArrayList<LottoBall> balls = new ArrayList<LottoBall>();
		for(int i=0;i<45;i++) {
			balls.add(new LottoBall(i+1));
		}
		return balls;
	}

}
