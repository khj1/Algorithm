package programmers.lv3;

public class 등굣길_42898 {

	private final int INF = 1_000_000_007;

	public int solution(int m, int n, int[][] puddles) {
		int[][] dp = new int[n + 1][m + 1];
		for (int[] puddle : puddles) {
			dp[puddle[1]][puddle[0]] = -1;
		}

		dp[1][1] = 1;

		for (int i = 2; i <= n; i++) {
			if (dp[i - 1][1] == -1 || dp[i][1] == -1) {
				dp[i][1] = -1;
			} else {
				dp[i][1] = 1;
			}
		}

		for (int i = 2; i <= m; i++) {
			if (dp[1][i - 1] == -1 || dp[1][i] == -1) {
				dp[1][i] = -1;
			} else {
				dp[1][i] = 1;
			}
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= m; j++) {
				if (dp[i][j] == -1) {
					continue;
				}
				if (dp[i - 1][j] == -1 && dp[i][j - 1] == -1) {
					dp[i][j] = -1;
				} else if (dp[i - 1][j] == -1) {
					dp[i][j] = dp[i][j - 1];
				} else if (dp[i][j - 1] == -1) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % INF;
				}
			}
		}

		return dp[n][m] == -1 ? 0 : dp[n][m] % INF;
	}
}
