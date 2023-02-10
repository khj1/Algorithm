package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO
public class 테트로미노_14500 {

	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int[] nR = {-1, 0, 1, 0};
	static int[] nC = {0, -1, 0, 1};
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		initMap(br);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, map[i][j]);
				visited[i][j] = false;

			}
		}

		System.out.println(max);
	}

	private static void initMap(BufferedReader br) throws IOException {
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
	}

	private static void dfs(int r, int c, int count, int area) {
		if (count == 4) {
			max = Math.max(max, area);
			return;
		}
		for (int k = 0; k < 4; k++) {
			int newR = r + nR[k];
			int newC = c + nC[k];

			if (newR < 0 || newC < 0 || newR >= N || newC >= M) {
				continue;
			}
			if (visited[newR][newC]) {
				continue;
			}
			if (count == 2) {
				visited[newR][newC] = true;
				dfs(r, c, count + 1, area + map[newR][newC]);
				visited[newR][newC] = false;
			}
			visited[newR][newC] = true;
			dfs(newR, newC, count + 1, area + map[newR][newC]);
			visited[newR][newC] = false;
		}
	}
}
