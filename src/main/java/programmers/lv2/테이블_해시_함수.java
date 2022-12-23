package programmers.lv2;

import java.util.Arrays;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/147354
 */
public class 테이블_해시_함수 {
	public int solution(int[][] data, int col, int row_begin, int row_end) {
		Arrays.sort(data, ((o1, o2) -> {
			if (o1[col - 1] == o2[col - 1]) {
				return o2[0] - o1[0];
			}
			return o1[col - 1] - o2[col - 1];
		}));
		return calculateXor(data, row_begin, row_end);
	}

	private int calculateXor(int[][] data, int rowBegin, int rowEnd) {
		int xor = 0;
		for (int i = rowBegin - 1; i < rowEnd; i++) {
			xor ^= calculateRow(data[i], i);
		}
		return xor;
	}

	private int calculateRow(int[] datum, int mod) {
		int sum = 0;
		for (int column : datum) {
			sum += column % (mod + 1);
		}
		return sum;
	}
}
