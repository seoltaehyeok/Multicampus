package ps.algorithm.sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSort qs = new QuickSort();
		qs.test1();
	}

	public void test1() {
		this.qSort(new int[] { 1, 8, 7, 4, 5, 2, 6, 3, 9 }, 0, 9-1);
	}

	public void qSort(int[] a, int left, int right) {
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
		System.out.println(Arrays.toString(a));
		if (left < pr) {
			qSort(a, left, pr);
		}
		if (right > pl) {
			qSort(a, pl, right);
		}
	}

	private void swap(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		// 교환 로직 작성
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
