package ps.algorithm.report1;

import java.util.Arrays;
import java.util.Scanner;

public class AlgorithmProject1 {

	public static void main(String[] args) {
		AlgorithmProject1 algo = new AlgorithmProject1();
		algo.test1();

	}

	public void test1() {
		Scanner scan = new Scanner(System.in);
		System.out.print("학생 수 입력: ");
		int N = scan.nextInt();
		int[] arr = new int[N];
		int left = 0;
		int right = N - 1;
		int half = arr[(left + right) / 2];
		for (int i = 0; i < N; i++) {
			System.out.print("학생 " + (i + 1) + " 점수 입력: ");
			arr[i] = scan.nextInt();
		}
		int a[] = qSort(arr, left, right);
		System.out.println(Arrays.toString(a));
	}

	public int[] qSort(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int x = a[(left + right) / 2];

		while (pl <= pr) {
			while (a[pl] < x) {
				pl++;
			}
			while (a[pr] > x) {
				pr--;
			}
			if (pl <= pr) {
				this.swap(a, pl++, pr--);
			}
		}
		if (left < pr) {
			qSort(a, left, pr);
		}
		if (right > pl) {
			qSort(a, pl, right);
		}
		return a;
	}

	void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
