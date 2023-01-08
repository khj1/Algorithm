package programmers.lv2;

import java.util.Arrays;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/12913
 */
public class 땅따먹기 {
	int solution(int[][] land) {
		int answer = 0;

		for (int i = 1; i < land.length; i++) {
			land[i][0] += Math.max(Math.max(land[i - 1][1], land[i - 1][2]), land[i - 1][3]);
			land[i][1] += Math.max(Math.max(land[i - 1][0], land[i - 1][2]), land[i - 1][3]);
			land[i][2] += Math.max(Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][3]);
			land[i][3] += Math.max(Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][2]);
		}
		return Arrays.stream(land[land.length - 1])
				.max()
				.getAsInt();
	}
}
