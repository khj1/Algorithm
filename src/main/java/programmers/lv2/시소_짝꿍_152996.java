package programmers.lv2;

import java.util.Arrays;

public class 시소_짝꿍_152996 {

	public long solution(int[] weights) {
		long totalCount = 0;
		Arrays.sort(weights);

		int tempCount = 0;
		for (int i = 0; i < weights.length; i++) {
			if (i > 0 && weights[i] == weights[i - 1]) {
				tempCount--;
				totalCount += tempCount;
				continue;
			}
			tempCount = 0;

			for (int j = i + 1; j < weights.length; j++) {
				if (weights[i] == weights[j]
						|| weights[i] * 3 == weights[j] * 2
						|| weights[i] * 4 == weights[j] * 2
						|| weights[i] * 4 == weights[j] * 3
				) {
					tempCount++;
				}
			}
			totalCount += tempCount;
		}
		return totalCount;
	}
}
