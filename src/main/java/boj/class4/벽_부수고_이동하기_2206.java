package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TODO
public class 벽_부수고_이동하기_2206 {

	static int N;
	static int M;
	static int[][] map;
	static int[] nR = {-1, 0, 1, 0};
	static int[] nC = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		System.out.println(bfs(0, 0));
	}

	private static int bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r, c, 1, true));
		boolean[][] visitedWhenUnbreakable = new boolean[N][M];
		boolean[][] visitedWhenBreakable = new boolean[N][M];
		visitedWhenUnbreakable[r][c] = true;
		visitedWhenBreakable[r][c] = true;
		boolean isCompleted = false;
		int minDist = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			Point current = queue.poll();
			if (current.r == N - 1 && current.c == M - 1) {
				isCompleted = true;
				minDist = Math.min(minDist, current.distance);
				continue;
			}
			if (map[current.r][current.c] == 1) {
				if (current.breakable) {
					current.breakable = false;
				} else {
					continue;
				}
			}

			for (int i = 0; i < 4; i++) {
				int nextR = current.r + nR[i];
				int nextC = current.c + nC[i];

				if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M) {
					continue;
				}
				if (current.breakable) {
					if (visitedWhenBreakable[nextR][nextC]) {
						continue;
					}
					visitedWhenBreakable[nextR][nextC] = true;
				} else {
					if (visitedWhenUnbreakable[nextR][nextC]) {
						continue;
					}
					visitedWhenUnbreakable[nextR][nextC] = true;
				}
				queue.add(new Point(nextR, nextC, current.distance + 1, current.breakable));
			}
		}

		if (isCompleted) {
			return minDist;
		}
		return -1;
	}

	static class Point {
		int r;
		int c;
		int distance;
		boolean breakable;

		public Point(int r, int c, int distance, boolean breakable) {
			this.r = r;
			this.c = c;
			this.distance = distance;
			this.breakable = breakable;
		}
	}

}
