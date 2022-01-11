package study.baseball;

import java.util.ArrayList;
import java.util.Random;

public class NumberBaseballGame {
	private ArrayList<String> hiddenNumber;

	// 요청된 네자리수에 대해 중복처리 여부 확인하여 결과 리턴
	public boolean isSameNumber(String number) {
		boolean flag = false;

		return flag;
	}

	public void setHiddenNumber(String number) {
		for (int i = 0; i < number.length(); i++) {
			String num = String.valueOf(number.charAt(i));
			hiddenNumber.add(num);
		}
	}
	public void makeHiddenNumber() {
		ArrayList<String> tempNumber = new ArrayList<String>();

		while (true) {
			Random rand = new Random();
			// 중복여부판단을 위해 isSameNumber에게 넘겨줌
			int number = rand.nextInt(9000) + 1000;
			System.out.printf("random number is %d %n", number);
			boolean flag = this.isSameNumber(String.valueOf(number)); // char형 타입 값을 String으로 변환하여 할당
			hiddenNumber = tempNumber;
			if (!flag) {
				hiddenNumber = new ArrayList<String>();
				this.setHiddenNumber(String.valueOf(number));
				break;
			}
		}
	}

	// 중복되지 않은 4자리 숫자인 hiddenNumber 생성
	public int[] judgeNumber(String tryNumber) {
		int[] result = { 0, 0 };

		return result;
	}

	// hiddenNumber하고 사용자가 입력한 숫자 비교하여 결과 리턴 (중요)
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s %s %s %s", hiddenNumber.get(0), hiddenNumber.get(1), hiddenNumber.get(2),
				hiddenNumber.get(3));
	}
}
