package study.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		HashMapTest hm = new HashMapTest();
		hm.test1();
	}

	public void test1() {
		System.out.println("HashMap Test");
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		// 생성
		map.put("one", 10);
		map.put("two", 20);
		map.put("three", 3);
		map.put("four", 10);
		map.put("fiv", 20);
		map.put("six", 3);
		
		this.print(map);
		// 사이즈
		int size = map.size();
		System.out.printf("map size = %d %n", size);

		// 조회
		int value = map.get("one"); // Integer를 int로 바로 변환 (오토언박싱) : 제네릭이 있기 때문
		System.out.printf("read value is %d %n", value);

		// 갱신
		map.put("one", 1);
		value = map.get("one");
		System.out.printf("update value: %d %n", value);

		// 삭제
		value = map.remove("three");
		System.out.printf("remove value: %d %n", value);
	}

	// Iterator로 key, value 가져오기 (순서 x)
	public void print(HashMap<String, Integer> map) {
		Set<String> keys = map.keySet(); // Set: 집합요소 (중복x, 순서x)
		// Set은 집합의 요소로 순서가 없으므로 특정해서 값을 꺼낼 수가 없음
		// 따라서 iterator를 통해 열거를 함 (열거자)
		Iterator<String> iter = keys.iterator();
		System.out.println();
		while (iter.hasNext()) {
			String key = iter.next();
			Integer value = map.get(key);
//				int value = (int) map.get(key);
//				int value = map.get(key);
			System.out.printf("key : %s, value : %d %n", key, value);
		}

	}
}
