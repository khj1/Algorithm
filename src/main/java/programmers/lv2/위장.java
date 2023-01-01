package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */
public class 위장 {

	public int solution(String[][] clothes) {
		Map<String, Integer> fashion = new HashMap<>();
		for (String[] element : clothes) {
			fashion.put(element[1], fashion.getOrDefault(element[1], 0) + 1);
		}

		int answer = 1;
		for (int count : fashion.values()) {
			answer *= count + 1;
		}

		return answer - 1;
	}
}
