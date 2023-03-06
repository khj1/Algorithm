package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO
public class LCS_9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] sequenceA = br.readLine().split("");
		String[] sequenceB = br.readLine().split("");

		int r = sequenceA.length;
		int c = sequenceB.length;

		int[][] dp = new int[r + 1][c + 1];
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				if (sequenceA[i - 1].equals(sequenceB[j - 1])) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		System.out.println(dp[r][c]);
	}
}
