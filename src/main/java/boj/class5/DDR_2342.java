package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//TODO
public class DDR_2342 {

	static int[] targets;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] line = br.readLine().split(" ");
		targets = new int[line.length - 1];

		for (int i = 0; i < line.length - 1; i++) {
			targets[i] = Integer.parseInt(line[i]);
		}

		dp = new int[5][5][line.length];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		bw.write(String.valueOf(solve(0, 0, 0)));
		bw.flush();
		bw.close();
		br.close();
	}

	static int solve(int left, int right, int count) {
		if (count == targets.length) {
			return 0;
		}
		if (dp[left][right][count] != -1) {
			return dp[left][right][count];
		}

		int moveLeft = solve(targets[count], right, count + 1) + move(left, targets[count]);
		int moveRight = solve(left, targets[count], count + 1) + move(right, targets[count]);

		dp[left][right][count] = Math.min(moveLeft, moveRight);

		return dp[left][right][count];

	}

	static int move(final int current, final int next) {
		int diff = Math.abs(current - next);
		if (current == 0) {
			return 2;
		}
		if (diff == 0) {
			return 1;
		}
		if (diff == 1 || diff == 3) {
			return 3;
		}
		return 4;
	}

}
