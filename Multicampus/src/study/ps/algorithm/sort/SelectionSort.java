package ps.algorithm.sort;

import java.util.Arrays;

public class SelectionSort {
	// 선택정렬: 현재 인덱스와 최솟값 인덱스를 찾아서 서로 바꿔 정렬
	// 각 인덱스 마다 전체 케이스를 훑기 때문에 맨 왼쪽부터 차례대로 정렬되어 진다.
	// 평균: N^2, 최악: N^2, 메모리: N1, 안정성x
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 5, 7, 3, 2, 6, 10, 15, 4 };

		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j])
					min = j; 	// 최소 색인 찾기
			}
			swap(arr, i, min);
			System.out.println(Arrays.toString(arr));
		}
	}

	private static void swap(int[] a, int index1, int index2) {
		// TODO Auto-generated method stub
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
}