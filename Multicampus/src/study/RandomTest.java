package study;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomTest rt = new RandomTest();
		rt.Random();
	}

	public void Random() {

		double rand1 = Math.random(); // 0.0<=rand1<1.0
		System.out.println("0.0<=rand1<1.0");
		System.out.println(rand1+"\n");
		Random r = new Random();
		// 0<=rand2<100
		System.out.println("0<=rand2<100");
		int rand2 = r.nextInt(100);
		System.out.println(rand2+"\n");

		System.out.println("1000<=rand2<9999");
		int rand3 = r.nextInt(9000) + 1000; // 0~8999 + 1000 => 1000~9999
		System.out.println(rand3+"\n");
		
		System.out.println("중복되지 않는 4자리수 출력하시오.");
		int[] rand4 = new int[10];
		for (int i = 0; i < 10; i++) {
			rand4[i] = r.nextInt(9000)+1000;
			for (int j = 0; j < i; j++) {
				if(rand4[i] == rand4[j]) {
					i--;
					break;
				}
			}
		}
		for(int i=0; i<10; i++)
			System.out.println(rand4[i]);
	}
}
