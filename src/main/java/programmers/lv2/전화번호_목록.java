package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */
public class 전화번호_목록 {
	public boolean solution(String[] phone_book) {
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < phone_book.length; i++) {
			map.put(phone_book[i], i);
		}

		for (String phoneNumber : phone_book) {
			for (int i = 0; i < phoneNumber.length(); i++) {
				String prefix = phoneNumber.substring(0, i);
				if (map.containsKey(prefix)) {
					return false;
				}
			}
		}
		return true;
	}
}
