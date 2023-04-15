package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class LCS_2_9252 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] sequenceA = br.readLine().toCharArray();
		char[] sequenceB = br.readLine().toCharArray();

		int r = sequenceA.length;
		int c = sequenceB.length;

		int[][] dp = new int[r + 1][c + 1];

		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				if (sequenceA[i - 1] == sequenceB[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		Stack<Character> stack = new Stack<>();

		while (dp[r][c] > 0) {
			if (dp[r][c] == dp[r - 1][c]) {
				r--;
			} else if (dp[r][c] == dp[r][c - 1]) {
				c--;
			} else {
				stack.add(sequenceA[r - 1]);
				r--;
				c--;
			}
		}

		int size = stack.size();

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		bw.write(size + "\n" + sb);
		bw.flush();
		bw.close();
		br.close();
	}

}
