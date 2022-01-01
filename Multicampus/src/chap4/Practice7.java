package chap4;

public class Practice7 {

//	public static void main(String[] args) {
//		String str = "12345";
//		int sum = 0;
//		
//		for(int i=0; i < str.length(); i++) {
//			sum +=	str.charAt(i);
//
//			System.out.println("sum=" + sum);
//			}
//		
//		System.out.println("sum=" + sum);
//	}

	public static void main(String[] args) {
		String str = "12345";
		int sum = 0;
		int one = Integer.parseInt(str);

		for (int i = 0; i < str.length(); i++) {

			sum += one % 10;
			one = one / 10;
		}
		System.out.println("sum=" + sum);
	}
}
