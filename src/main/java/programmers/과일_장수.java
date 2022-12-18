package programmers;

import java.util.Arrays;
import java.util.Collections;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/135808
 */
public class 과일_장수 {

	public int solution(int k, int m, int[] score) {
		int answer = 0;
		Integer[] boxedScore = boxScore(score);
		Arrays.sort(boxedScore, Collections.reverseOrder());

		int priceIndex = m - 1;
		while (priceIndex < score.length) {
			answer += m * boxedScore[priceIndex];
			priceIndex += m;
		}
		return answer;
	}

	private static Integer[] boxScore(int[] score) {
		return Arrays.stream(score)
			.boxed()
			.toArray(Integer[]::new);
	}
}
