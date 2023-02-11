package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리_1149 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] costs = new int[N + 1][4];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 3; j++) {
				costs[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[N + 1][4];
		dp[1][1] = costs[1][1];
		dp[1][2] = costs[1][2];
		dp[1][3] = costs[1][3];

		for (int i = 2; i <= N; i++) {
			dp[i][1] = Math.min(costs[i][1] + dp[i - 1][2], costs[i][1] + dp[i - 1][3]);
			dp[i][2] = Math.min(costs[i][2] + dp[i - 1][1], costs[i][2] + dp[i - 1][3]);
			dp[i][3] = Math.min(costs[i][3] + dp[i - 1][1], costs[i][3] + dp[i - 1][2]);
		}
		System.out.println(Math.min(Math.min(dp[N][1], dp[N][2]), dp[N][3]));
	}
}
