package programmers.lv3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 보석_쇼핑_67258 {

	public int[] solution(String[] gems) {
		int[] answer = new int[2];

		Set<String> uniqueGems = new HashSet<>(Arrays.asList(gems));
		int uniqueCount = uniqueGems.size();
		if (uniqueCount == 1) {
			return new int[] {1, 1};
		}

		Map<String, Integer> jewelCount = new HashMap<>();
		Set<String> uniqueBasket = new HashSet<>();
		int min = Integer.MAX_VALUE;
		int start = 0;
		int end = 1;

		jewelCount.put(gems[start], jewelCount.getOrDefault(gems[start], 0) + 1);
		jewelCount.put(gems[end], jewelCount.getOrDefault(gems[end], 0) + 1);

		uniqueBasket.add(gems[start]);
		uniqueBasket.add(gems[end]);

		while (end < gems.length) {
			if (uniqueBasket.size() < uniqueCount) {
				end++;
				if (end < gems.length) {
					uniqueBasket.add(gems[end]);
					jewelCount.put(gems[end], jewelCount.getOrDefault(gems[end], 0) + 1);
				}
			} else if (uniqueBasket.size() == uniqueCount) {
				if (end - start < min) {
					min = end - start;
					answer[0] = start + 1;
					answer[1] = end + 1;
				}
				if (jewelCount.get(gems[start]) <= 1) {
					uniqueBasket.remove(gems[start]);
				}
				jewelCount.put(gems[start], jewelCount.get(gems[start]) - 1);
				start++;
			}
		}
		return answer;
	}
}
