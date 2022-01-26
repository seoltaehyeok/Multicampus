package ps.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
	// 버블정렬: 배열을 순차적으로 돌면서 다음인덱스가 현재 인덱스보다 큰 경우 계속해서 뒤로 이동시킴
	// 1회차를 다 돌았을 때 가장 큰 수는 맨 뒤에 위치하게 되어 있음
	// 평균: N^2, 최악: N^2, 메모리: N1, 안정성o
	public static void main(String[] args) {
		int arr[] = { 1, 5, 7, 3, 2, 6, 10, 15, 4 };
		int temp;
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-i-1; j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			System.out.println(Arrays.toString(arr));
		}
	}

}



//int arr[] = { 1, 5, 7, 3, 2, 6, 10, 15, 4 };
//int temp = 0;
//for (int i = 0; i < arr.length - 1; i++) {
//	for (int j = i + 1; j < arr.length; j++) {
//		if (arr[i] > arr[j]) {
//			temp = arr[i];
//			arr[i] = arr[j];
//			arr[j] = temp;
//		}
//	}
//	System.out.println(Arrays.toString(arr));
//}
//System.out.println();
//System.out.println(Arrays.toString(arr));
