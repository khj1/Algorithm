package programmers.lv2;

import java.util.Arrays;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/135807
 */
public class 숫자_카드_나누기 {

	public int solution(int[] arrayA, int[] arrayB) {
		int answer = 0;

		Arrays.sort(arrayA);
		Arrays.sort(arrayB);

		int dividableA = findDividable(arrayA, arrayB);
		int dividableB = findDividable(arrayB, arrayA);

		if (dividableA != 0 || dividableB != 0) {
			answer = Integer.max(dividableA, dividableB);
		}
		return answer;
	}

	private int findDividable(int[] arr, int[] otherArr) {
		for (int i = arr[0]; i > 0; i--) {
			if (isDividable(i, arr) && isNotDividable(i, otherArr)) {
				return i;
			}
		}
		return 0;
	}

	private boolean isDividable(int dividing, int[] arr) {
		for (int cardNumber : arr) {
			if (cardNumber % dividing != 0) {
				return false;
			}
		}
		return true;
	}

	private boolean isNotDividable(int dividing, int[] arr) {
		for (int cardNumber : arr) {
			if (cardNumber % dividing == 0) {
				return false;
			}
		}
		return true;
	}
}
