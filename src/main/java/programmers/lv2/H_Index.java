package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42747
 */
public class H_Index {
	public int solution(int[] citations) {
		List<Integer> hIndexes = calculateHIndexes(citations);
		return hIndexes.stream()
				.max(Integer::compareTo)
				.orElse(0);
	}

	private List<Integer> calculateHIndexes(int[] citations) {
		List<Integer> hIndexes = new ArrayList<>();
		for (int i = 0; i <= citations.length; i++) {
			int upperCount = calculateUpperCount(citations, i);
			int lowerCount = calculateLowerCount(citations, i);

			if (upperCount >= i && lowerCount <= citations.length - i) {
				hIndexes.add(i);
			}
		}
		return hIndexes;
	}

	private int calculateUpperCount(int[] citations, int i) {
		int count = 0;
		for (int citation : citations) {
			if (citation >= i) {
				count++;
			}
		}
		return count;
	}

	private int calculateLowerCount(int[] citations, int i) {
		int count = 0;
		for (int citation : citations) {
			if (citation < i) {
				count++;
			}
		}
		return count;
	}
}
