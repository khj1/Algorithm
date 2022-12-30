package programmers.lv2;

import java.util.Arrays;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */
public class 가장_큰_수 {

	public String solution(int[] numbers) {

		String[] strings = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			strings[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(strings, this::sortBigger);
		if (strings[0].equals("0")) {
			return "0";
		}
		return String.join("", strings);
	}

	private int sortBigger(String prev, String next) {
		return next.concat(prev).compareTo(prev.concat(next));
	}
}
