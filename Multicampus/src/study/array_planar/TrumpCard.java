package study.array.card;

import java.util.Random;

public class TrumpCard {

	public static void main(String[] args) {
		// 2차원 배열을 가지고 카드 52장을 표현해 보세요
		// 카드 종류는 spade, heart, clover, diamond, 숫자1~13
		TrumpCard tc = new TrumpCard();
		tc.makeCardV1();
		tc.makeCardV2();
		
	}

	public void makeCardV1() {
		int[] spade = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		int[] diamond = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		int[] clover = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		int[] heart = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		
		int[][] card = {spade, heart, diamond, clover};
		
		int size1 = card.length;
		int size2 = card[0].length;
		System.out.printf("size1 is %d, size2 is %d \n", size1, size2);
	}
	
	public void makeCardV2() {
		String[][] deck = new String[4][13]; // Heart-1;
		String[] suite = {"Spade", "Heart", "Diamond", "Clover"};
		for(int i=0; i<deck.length; i++) {
			for(int j=0; j<deck[i].length; j++) {
				deck[i][j] = suite[i]+"-"+(j+1);
			}
		}
		this.shuffle(deck);
		this.printCard(deck);
	}
	
	public void shuffle(String[][] deck) {
		// 교환로직을 구현
		Random r = new Random();
		for(int i=0; i<100; i++) {
			int r1= r.nextInt(4);
			int c1 = r.nextInt(13);
			
			int r2 = r.nextInt(4);
			int c2 = r.nextInt(13);
			
			String temp = deck[r1][c1];
			deck[r1][c1] = deck[r2][c2];
			deck[r2][c2] = temp;
		}
	}
	
	public void printCard(String[][] deck) {
		for(int i=0; i<deck.length; i++) {
			for(int j=0; j<deck[i].length; j++) {
				System.out.println(deck[i][j]);
			}
		}
	}
}

//	HashMap <String, Integer>  hm = new HashMap<>();
//	String arr[] = { "Spade", "heart", "clover", "diamond" };
//	for(int i=0; i<arr.length; i++) {
//		for(int j=0; j<13; j++) {
//			hm.put(arr[i], j);
//		}
//	}
//	Iterator<String> keys = hm.keySet().iterator();
//	while(keys.hasNext()) {
//		String key = keys.next();
//		 System.out.println("[Key]:" + key + " [Value]:" +  hm.get(key));
//	}
//
//}