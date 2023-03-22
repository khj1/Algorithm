package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 알파벳_1987 {

	static int R, C;
	static int[][] alphabets;

	static int maxCount = 0;
	static int[] nR = {-1, 0, 1, 0};
	static int[] nC = {0, -1, 0, 1};
	static boolean[] visited = new boolean[26];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alphabets = new int[R][C];

		for (int i = 0; i < R; i++) {
			char[] chars = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				alphabets[i][j] = chars[j] - 'A';
			}
		}

		dfs(0, 0, 0);

		bw.write(String.valueOf(maxCount));
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(final int r, final int c, final int count) {
		int current = alphabets[r][c];
		if (visited[current]) {
			maxCount = Math.max(maxCount, count);
		} else {
			visited[current] = true;

			for (int i = 0; i < 4; i++) {
				int nextR = r + nR[i];
				int nextC = c + nC[i];

				if (nextR < 0 || nextC < 0 || nextR >= R || nextC >= C) {
					continue;
				}

				dfs(nextR, nextC, count + 1);
			}

			visited[current] = false;
		}

	}
}
