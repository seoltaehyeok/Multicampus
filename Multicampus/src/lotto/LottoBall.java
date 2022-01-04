package lotto;

public class LottoBall {
	
	// 공의 숫자정보 필요
	int ballNumber;
	// 뽑힌적이 있는 공인지(중복 방지)
	boolean isSelected;
	
	// 공의 상태정보
	LottoBall(int ballNumber){
		this.ballNumber = ballNumber;
	}
}
