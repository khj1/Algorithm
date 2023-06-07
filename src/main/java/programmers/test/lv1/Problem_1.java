package programmers.test.lv1;

import java.util.ArrayList;
import java.util.List;

public class Problem_1 {
	public int[] solution(int[] arr, int divisor) {
		List<Integer> answer = new ArrayList<>();

		for (int number : arr) {
			if (number % divisor == 0) {
				answer.add(number);
			}
		}

		if (answer.isEmpty()) {
			return new int[] {-1};
		}
		return answer.stream()
				.sorted()
				.mapToInt(i -> i)
				.toArray();
	}
}
