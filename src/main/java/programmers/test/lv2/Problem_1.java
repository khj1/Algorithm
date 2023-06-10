package programmers.test.lv2;

import java.util.HashMap;
import java.util.Map;

public class Problem_1 {

	public boolean solution(String[] phone_book) {
		Map<String, Integer> map = new HashMap<>();
		for (String phoneNumber : phone_book) {
			map.put(phoneNumber, 0);
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
