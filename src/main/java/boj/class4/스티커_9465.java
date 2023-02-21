package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO
public class 스티커_9465 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] stickers = fillStickers(br, n);
			int[][] dp = new int[3][n + 1];

			dp[1][1] = stickers[1][1];
			dp[2][1] = stickers[2][1];

			for (int j = 2; j <= n; j++) {
				dp[1][j] = Math.max(dp[2][j - 1], dp[2][j - 2]) + stickers[1][j];
				dp[2][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + stickers[2][j];
			}
			System.out.println(Math.max(dp[1][n], dp[2][n]));
		}
	}

	private static int[][] fillStickers(BufferedReader br, int n) throws IOException {
		int[][] stickers = new int[3][n + 1];
		for (int j = 1; j <= 2; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int k = 1; k <= n; k++) {
				stickers[j][k] = Integer.parseInt(st.nextToken());
			}
		}
		return stickers;
	}
}
