package mini_report.lotto;

public class LottoBall {
	private int ballNumber;

	public LottoBall(int ballNumber){
		this.ballNumber = ballNumber;
	}
	
	public int getBallNumber() {
		return ballNumber;
	}
	
//		
//	private void setBallNumber(int ballNumber) {
//		this.ballNumber = ballNumber;
//	}
//	
//		
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "나의 번호는 "+this.ballNumber+"입니다";
	}
	
}
