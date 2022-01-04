package lotto;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		Test ts = new Test();
		ts.test();
		// Random 클래스의 인스턴스를 생성
	}
	public void test() {
		System.out.println("test");
		Random rm = new Random();
		int count=0;
		
		// case 10개를 생성
		while(count<10) {
		//  1~45까지의 수 6개를 생성하는 코드를 작성
		for(int i=0; i<7; i++) {
		int rand = rm.nextInt(45)+1;
		if(i==6) {
			System.out.println("\n2등 보너스 당첨번호는 : " + rand + "입니다");
			System.out.println();
		}
		else 
			System.out.print(rand + " ");
		}
		count++;
		}
	}
}


