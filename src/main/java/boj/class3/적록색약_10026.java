package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약_10026 {

	static int[] nR = {-1, 0, 1, 0};
	static int[] nC = {0, -1, 0, 1};
	static String[][] map;
	static boolean[][] visitedForColor;
	static boolean[][] visitedForNormal;

	static int N;
	static int normalCount = 0;
	static int colorCount = 0;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		visitedForColor = new boolean[N][N];
		visitedForNormal = new boolean[N][N];
		map = new String[N][N];

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = split[j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visitedForColor[i][j]) {
					colorCount++;
					bfsForColor(i, j);
				}
				if (!visitedForNormal[i][j]) {
					normalCount++;
					bfsForNormal(i, j);
				}
			}
		}

		sb.append(normalCount).append(" ").append(colorCount);
		System.out.println(sb);
	}

	private static void bfsForColor(int i, int j) {
		Queue<Point> queue = new LinkedList<>();
		visitedForColor[i][j] = true;
		queue.add(new Point(i, j));
		while (!queue.isEmpty()) {
			Point currentPoint = queue.poll();
			String currentColor = map[currentPoint.r][currentPoint.c];
			for (int k = 0; k < 4; k++) {
				int newR = currentPoint.r + nR[k];
				int newC = currentPoint.c + nC[k];

				if (newR < 0 || newC < 0 || newR >= N || newC >= N) {
					continue;
				}
				if (visitedForColor[newR][newC]) {
					continue;
				}
				if ((currentColor.equals("R") || currentColor.equals("G")) && map[newR][newC].equals("B")) {
					continue;
				}
				if (currentColor.equals("B") && !map[newR][newC].equals("B")) {
					continue;
				}
				visitedForColor[newR][newC] = true;
				queue.add(new Point(newR, newC));
			}
		}
	}

	private static void bfsForNormal(int i, int j) {
		Queue<Point> queue = new LinkedList<>();
		visitedForNormal[i][j] = true;
		queue.add(new Point(i, j));
		while (!queue.isEmpty()) {
			Point currentPoint = queue.poll();
			String currentColor = map[currentPoint.r][currentPoint.c];
			for (int k = 0; k < 4; k++) {
				int newR = currentPoint.r + nR[k];
				int newC = currentPoint.c + nC[k];

				if (newR < 0 || newC < 0 || newR >= N || newC >= N) {
					continue;
				}
				if (visitedForNormal[newR][newC] || !map[newR][newC].equals(currentColor)) {
					continue;
				}
				visitedForNormal[newR][newC] = true;
				queue.add(new Point(newR, newC));
			}
		}
	}

	static class Point {

		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
