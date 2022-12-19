package programmers.lv2;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/138476
 */
public class 귤_고르기 {

	public int solution(int k, int[] tangerine) {
		Map<Integer, Integer> tangerineByType = countTangerineByType(tangerine);
		List<Integer> tangerineCounts = tangerineByType.values().stream()
			.sorted(Collections.reverseOrder())
			.collect(Collectors.toList());

		int answer = 0;
		while (k > 0) {
			k -= tangerineCounts.get(answer);
			answer++;
		}
		return answer;
	}

	private Map<Integer, Integer> countTangerineByType(int[] tangerine) {
		Map<Integer, Integer> tangerineCounts = new HashMap<>();
		for (int tangerineType : tangerine) {
			tangerineCounts.put(tangerineType, tangerineCounts.getOrDefault(tangerineType, 0) + 1);
		}
		return tangerineCounts;
	}
}
