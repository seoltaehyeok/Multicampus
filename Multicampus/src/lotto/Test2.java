package lotto;

import java.util.Random;

public class Test2 {

	public static void main(String[] args) {
		Test2 ts = new Test2();
		ts.test2();
		// Random 클래스의 인스턴스를 생성
	}

	public void test2() {
		System.out.println("test");
		Random rm = new Random();
		int count = 0;
		int[] rand = new int[7];
		// case 10개를 생성
		while (count < 10) {
			// 1~45까지의 수 6개를 생성하는 코드를 작성 (+2등 당첨번호)
			for (int i = 0; i < 7; i++) {
				rand[i] = rm.nextInt(45) + 1;
				for (int j = 0; j < i; j++) {
					if (rand[i] == rand[j]) {
						i--;			// rand[0] 과 rand[1] 이 같은 값이 나온다면 rand[1]을 rand[0]으로 돌려서 새로운 값 할당 
						break;
					}
				}
			}
			for (int i = 0; i < 7; i++) {
				if (i == 6) {
					System.out.println("\n2등 보너스 당첨번호는 : " + rand[i] + "입니다");
					System.out.println();
				} else
					System.out.print(rand[i] + " ");
			}
			count++;
		}
	}
}
