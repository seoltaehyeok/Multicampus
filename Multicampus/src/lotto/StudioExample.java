package lotto;

public class StudioExample {

	public static void main(String[] args) {
		StudioExample studio = new StudioExample();
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
		System.out.println("로또 공을 생성합니다.");
		System.out.println("로또 공을 머신에 다시 넣습니다.");
		machine = new LottoMachine(null);
		return machine;
	}

}
