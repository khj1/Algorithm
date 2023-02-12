package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정수_삼각형_1932 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n + 1][n + 1];
		dp[1][1] = Integer.parseInt(br.readLine());

		for (int i = 2; i <= n; i++) {
			int[] numbers = new int[i + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {
				numbers[j] = Integer.parseInt(st.nextToken());
			}

			dp[i][1] = numbers[1] + dp[i - 1][1];
			for (int j = 2; j < i; j++) {
				dp[i][j] = Math.max(numbers[j] + dp[i - 1][j - 1], numbers[j] + dp[i - 1][j]);
			}
			dp[i][i] = numbers[i] + dp[i - 1][i - 1];
		}

		int max = Arrays.stream(dp[n])
				.max()
				.orElse(0);

		System.out.println(max);
	}
}
