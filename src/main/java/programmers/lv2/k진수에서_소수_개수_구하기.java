package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/92335
 */
public class k진수에서_소수_개수_구하기 {
	public int solution(int n, int k) {
		int count = 0;
		String nDecimal = Integer.toString(n, k);

		if (!nDecimal.contains("0")) {
			long number = Long.parseLong(nDecimal);
			if (isPrime(number)) {
				count++;
			}
		} else {
			Queue<Character> queue = toQueue(nDecimal);
			String candidate = "";
			while (!queue.isEmpty()) {
				char polled = queue.poll();
				if (polled == '0') {
					if (!candidate.isBlank() && isPrime(Long.parseLong(candidate))) {
						count++;
					}
					candidate = "";
				} else {
					candidate += polled;
				}
			}
			if (!candidate.isBlank() && isPrime(Long.parseLong(candidate))) {
				count++;
			}
		}
		return count;
	}

	private boolean isPrime(long number) {
		if (number < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	private Queue<Character> toQueue(String nDecimal) {
		Queue<Character> queue = new LinkedList<>();
		for (char aChar : nDecimal.toCharArray()) {
			queue.add(aChar);
		}
		return queue;
	}
}
