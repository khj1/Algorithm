package programmers.test.lv1;

public class Problem_6 {
	public int solution(int n) {
		int count = 0;
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				count++;
			}
		}
		return count;
	}

	private boolean isPrime(final int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
