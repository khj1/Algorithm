package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO
public class NQueen_9663 {

	static int N;
	static int totalCount = 0;
	static int[] queen;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		queen = new int[N];

		dfs(0);

		System.out.println(totalCount);
	}

	private static void dfs(int col) {
		if (col == N) {
			totalCount++;
			return;
		}
		for (int i = 0; i < N; i++) {
			queen[col] = i;

			if (canPut(col)) {
				dfs(col + 1);
			}
		}
	}

	private static boolean canPut(int col) {
		for (int i = 0; i < col; i++) {
			if (queen[col] == queen[i]) {
				return false;
			}
			if (Math.abs(col - i) == Math.abs(queen[col] - queen[i])) {
				return false;
			}
		}
		return true;
	}
}
