package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//TODO
//DP로 다시풀기
public class 팰린드롬_10942 {

	static int N, M;
	static int[] numbers;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		numbers = new int[N + 1];
		dp = new int[N + 1][N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				if (isPalindrome(i, j)) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = 0;
				}
			}
		}

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			sb.append(dp[start][end]).append(System.lineSeparator());
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static boolean isPalindrome(int start, int end) {
		while (start < end) {
			if (numbers[start] != numbers[end]) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
