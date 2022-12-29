package programmers.lv2;

import java.util.HashSet;
import java.util.Set;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42839
 */
public class 소수_찾기 {

	private String[] splitNumbers;
	private boolean[] visited;
	private final Set<Integer> uniquePrimes = new HashSet<>();

	public int solution(String numbers) {
		splitNumbers = numbers.split("");
		visited = new boolean[splitNumbers.length];

		dfs("", 0);

		return uniquePrimes.size();
	}

	private void dfs(String number, int count) {
		if (!number.isBlank()) {
			int primeCandidate = Integer.parseInt(number);
			if (isPrime(primeCandidate) && primeCandidate > 1) {
				System.out.println("primeCandidate = " + primeCandidate);
				uniquePrimes.add(primeCandidate);
			}
		}
		for (int i = 0; i < splitNumbers.length; i++) {
			if (count == splitNumbers.length) {
				break;
			}
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			dfs(number.concat(splitNumbers[i]), count + 1);
			visited[i] = false;
		}
	}

	private boolean isPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
