package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//TODO
public class 가장_긴_증가하는_부분_수열_11053 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] numbers = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 1];
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			dp[i] = 1;
			for (int j = 1; j <= i - 1; j++) {
				if (numbers[i] > numbers[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		int max = Arrays.stream(dp)
				.max()
				.orElse(1);

		System.out.println(max);
	}
}
