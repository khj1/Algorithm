package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO
public class 구간_합_구하기_5_11660 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		int[][] dp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + map[i][j];
			}
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int startR = Integer.parseInt(st2.nextToken());
			int startC = Integer.parseInt(st2.nextToken());
			int endR = Integer.parseInt(st2.nextToken());
			int endC = Integer.parseInt(st2.nextToken());

			int result = dp[endR][endC] - dp[startR - 1][endC] - dp[endR][startC - 1] + dp[startR - 1][startC - 1];
			sb.append(result).append(System.lineSeparator());
		}

		System.out.print(sb);
	}
}
