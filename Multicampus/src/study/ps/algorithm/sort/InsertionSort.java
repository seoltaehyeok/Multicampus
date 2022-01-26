package ps.algorithm.sort;

import java.util.Arrays;

public class InsertionSort {
	// 삽입정렬: 현재인덱스를 가지고 직전 값들과 비교하여 값이 작으면 안쪽에 삽입
	// 평균: N^2, 최악: N^2, 메모리: O1, 안정성o
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 5, 7, 3, 2, 6, 10, 15, 4 };
//		int arr[] = { 5, 3, 1, 3, 4, 6, 2 };
		int temp;
		for (int i = 1; i < arr.length; i++) {
			int j;
			int tmp = arr[i];
			for (j = i; j > 0 && arr[j - 1] > tmp; j--) { // j = i부터 / j>0 이면서 직전값이 현재값 보다 크다면
				arr[j] = arr[j - 1]; // 직전값을 현재값으로
			}
			arr[j] = tmp; // 
			System.out.println(Arrays.toString(arr));
		}
	}
}
