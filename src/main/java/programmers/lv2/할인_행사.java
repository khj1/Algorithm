package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/131127
 */
public class 할인_행사 {
	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		int position = 0;
		Map<String, Integer> wantedTypes = getWantedTypes(want, number);

		while (discount.length - position >= 10) {
			for (int i = position; i < 10 + position; i++) {
				String fruitType = discount[i];
				if (wantedTypes.containsKey(fruitType)) {
					wantedTypes.put(fruitType, wantedTypes.get(fruitType) - 1);
					if (wantedTypes.get(fruitType) == 0) {
						wantedTypes.remove(fruitType);
					}
				}
			}
			if (wantedTypes.isEmpty()) {
				answer++;
			}
			position++;
			wantedTypes = getWantedTypes(want, number);
		}

		return answer;
	}

	private Map<String, Integer> getWantedTypes(String[] want, int[] number) {
		HashMap<String, Integer> wantedCount = new HashMap<>();
		for (int i = 0; i < want.length; i++) {
			wantedCount.put(want[i], number[i]);
		}
		return wantedCount;
	}
}
