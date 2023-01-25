package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO
public class 계단_오르기_2579 {

	private static int[] stair;
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		stair = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}

		dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			if (i == 1) {
				dp[1] = stair[1];
			} else if (i == 2) {
				dp[2] = stair[1] + stair[2];
			} else if (i == 3) {
				dp[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);
			} else if (dp[i] == 0) {
				dp[i] = Math.max(dp[i - 2], dp[i - 3] + stair[i - 1]) + stair[i];
			}
		}
		System.out.println(dp[N]);
	}
}
