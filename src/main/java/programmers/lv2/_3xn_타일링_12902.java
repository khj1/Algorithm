package programmers.lv2;

public class _3xn_타일링_12902 {
	private final int MOD = 1_000_000_007;

	public long solution(int n) {
		long[] dp = new long[5001];
		dp[0] = 1;
		dp[2] = 3;

		for (int i = 4; i <= n; i += 2) {
			dp[i] = dp[i - 2] * 3;
			for (int j = i - 4; j >= 0; j -= 2) {
				dp[i] += dp[j] * 2;
			}
			dp[i] = dp[i] % MOD;
		}
		return dp[n];
	}
}
