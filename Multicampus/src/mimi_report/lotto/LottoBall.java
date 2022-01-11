package mimi_report.lotto;

public class LottoBall {

	// 공의 숫자정보 필요
	private int ballNumber; // 인스턴스
	// 뽑힌적이 있는 공인지(중복 방지)

	// 공의 상태정보
	public LottoBall(int ballNumber) { // 생성자
		this.ballNumber = ballNumber;
	}

	public int getBallNumber() {
		return ballNumber;
	}

	@Override
	public String toString() {
		return "나의 번호는 " +this.ballNumber+"입니다.";
	}

}
