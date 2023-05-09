package programmers.lv2;

import java.util.ArrayList;

public class 숫자_블록_12923 {
	public int[] solution(long begin, long end) {
		ArrayList<Integer> result = new ArrayList<>();
		for (long i = begin; i <= end; i++) {
			if (i == 1L) {
				result.add(0);
			} else {
				result.add(calculate(i));
			}
		}

		return result.stream()
				.mapToInt(x -> x)
				.toArray();
	}

	private int calculate(long n) {
		int max = 0;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				max = i;
				if (n / i <= 10_000_000) {
					return (int)(n / i);
				}
			}
		}
		if (max == 0) {
			return 1;
		}
		return max;
	}

}
