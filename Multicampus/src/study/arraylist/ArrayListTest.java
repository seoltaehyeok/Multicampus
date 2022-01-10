package study.arraylist;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayListTest alt = new ArrayListTest();
		alt.test1();
	}

	public void test1() {
		System.out.println("ArrayList test!");
		// ArrayList 인스턴스 생성
		ArrayList list = new ArrayList();
		// create (생성)
		list.add(new Integer(10)); // 다형성 1코드
		list.add(new Integer(2));
		list.add(new Integer(5));
		// list.add(new String("four"));
		int size = list.size();
		System.out.println("size : " + size);

		// 조회
		Integer num = (Integer) list.get(0); // 다형성 2코드 (Object의 객체를 Integer 객체로)
		int number = num.intValue(); // Integer클래스에서 intValue() 메소드 사용
		System.out.println("number: " + number);
		
		// 전체조회
		this.print(list);
		System.out.println();
		// 수정
		list.set(0, new Integer(1));
		this.print(list); // the value is 10 -> the value is 1
		System.out.println();
		
		// 삭제
		Integer delNumber = (Integer) list.remove(2); // 해당 index의 값 삭제
		this.print(list);
		System.out.println();
		System.out.println("delete Object number = " + delNumber.intValue());
		
	}
	
	public void print(ArrayList list) {
		for(int i=0; i<list.size(); i++) { // ArrayList는 가변 값을 가지므로 list.size를 통해 가변값을 할당
			Integer temp = (Integer)list.get(i);
			System.out.printf("the value is %d %n", temp.intValue());
		}
	}

}
