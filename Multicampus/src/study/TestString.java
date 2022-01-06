package study;

public class TestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test1() 메소드 호출하는 코드 작성하세요
		TestString ts = new TestString();
		ts.test1();
		ts.test2();
		ts.test3();
		ts.test4();
	}

	public void test1() {
		System.out.println("===test1===");
		String number = "123456";
		int val = Integer.parseInt(number);
		int len = number.length();
		int sum = val % 10;
		// 위의 number를 하나씩 분리하여 출력하시오
		for (int i = 0; i < len; i++) {
			System.out.println(number.charAt(i));
		}
		// 분리한 후 분리된 숫자의 합을 구하시오
		for (int i = 0; i < len; i++) {
			val = val / 10;
			sum = sum + (val % 10);
		}
		System.out.println(sum);
	}

	public void test2() {
		System.out.println("===test2===");
		String number = "123456";
		int sum = 0;
		for (int i = 0; i < number.length(); i++) {
			char digitLetter = number.charAt(i);
			System.out.println(digitLetter);
			String temp = String.valueOf(digitLetter);
			int num = Integer.parseInt(temp);
			sum = sum + num;
		}
		System.out.println(sum);
	}


	public void test3() {
		System.out.println("===test3===");
		String number = "123456";
		String[] numArray = number.split("");
		int sum = 0;
		for (int i = 0; i < numArray.length; i++) {
			sum = sum + Integer.parseInt(numArray[i]);
		}
		System.out.println(sum);
	}

	public void test4() {
		System.out.println("===test4===");
		String number = "123456";
		int sum = 0;
		for (int i = 0; i < number.length(); i++) {
			int n = number.charAt(i) - '0';
			sum += n;
		}
		System.out.println(sum);
	}
}
