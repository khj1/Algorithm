package programmers.test.lv1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem_4 {
	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];

		HashMap<Integer, Integer> countOfStuckUsersByStage = new HashMap<>();
		for (int i = 1; i <= N + 1; i++) {
			countOfStuckUsersByStage.put(i, 0);
		}

		for (int stage : stages) {
			countOfStuckUsersByStage.put(stage, countOfStuckUsersByStage.get(stage) + 1);
		}

		Map<Integer, Double> failRates = new HashMap<>();

		int totalCount = 0;
		for (int i = N + 1; i > 0; i--) {
			int stuckCount = countOfStuckUsersByStage.get(i);
			totalCount += stuckCount;
			if (i < N + 1) {
				if (totalCount == 0) {
					failRates.put(i, 0d);
				} else {
					failRates.put(i, (double)stuckCount / totalCount);
				}
			}
		}

		List<Map.Entry<Integer, Double>> entries = failRates.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toList());

		int i = 0;
		for (Map.Entry<Integer, Double> entry : entries) {
			answer[i++] = entry.getKey();
		}

		return answer;
	}
}
