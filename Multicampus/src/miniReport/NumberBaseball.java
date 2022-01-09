package miniReport;

import java.util.Random;
import java.util.Scanner;

public class NumberBaseball {

	public static void main(String[] args) {

		NumberBaseball nbe = new NumberBaseball();
		int SystemNumber = nbe.System();
		int PerseonNumber = nbe.Person();
		int strike = nbe.Program(SystemNumber, PerseonNumber);

		while (strike!=4) {
			System.out.println();
			if (strike != 4) {
				Scanner sn = new Scanner(System.in);
				System.out.println("게임을 포기하시겠습니까? (Y/N)");
				char tf = sn.next().charAt(0);
				if (tf == 'y' || tf == 'Y') {
					System.out.println("기권하였습니다.");
					break;
				}
			}
			SystemNumber = nbe.System();
			PerseonNumber = nbe.Person();
			strike = nbe.Program(SystemNumber, PerseonNumber);
		}
		if (strike == 4)
			System.out.println("\n축하합니다. 게임에서 승리하였습니다.");
	}

	public int System() {
		Random rand = new Random();
		int[] randNum = new int[4];
		int sum = 0;
		int z = 1;
		randNum[0] = rand.nextInt(9) + 1;
		for (int i = 1; i < 4; i++) {
			randNum[i] = rand.nextInt(10);
			for (int j = 0; j < i; j++) {
				if (randNum[i] == randNum[j]) {
					i--;
					break;
				}
			}
		}
		for (int i = 3; i >= 0; i--) {
			sum += randNum[i] * z;
			z = z * 10;
		}
		System.out.printf("시스템 랜덤 수 생성 (%d)\n", sum);
		return sum;
	}

	public int Person() {
		Scanner sn = new Scanner(System.in);
		System.out.print("임의의 4자리 수를 입력하세요: ");
		int num = sn.nextInt();

		return num;
	}

	public int Program(int system, int person) {
		int[] sysArr = new int[4];
		int[] perArr = new int[4];
		int strike = 0;
		int ball = 0;
		sysArr[3] = system % 10;
		perArr[3] = person % 10;
		for (int i = 2; i >= 0; i--) {
			system /= 10;
			person /= 10;
			sysArr[i] = system % 10;
			perArr[i] = person % 10;
		}

		for (int i = 0; i < 4; i++) {
			if (sysArr[i] == perArr[i])
				strike++;
			else {
				for (int j = 0; j < 4; j++) {
					if (sysArr[i] == perArr[j])
						ball++;
				}
			}
		}
		System.out.printf("스트라이크: %d, 볼: %d", strike, ball);
		return strike;
	}
}
