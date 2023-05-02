package programmers.lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 무인도_여행_154540 {

	private int N, M;
	private boolean visited[][];
	private int[] nR = {-1, 0, 1, 0};
	private int[] nC = {0, -1, 0, 1};

	public int[] solution(String[] maps) {
		N = maps.length;
		M = maps[0].length();

		List<Integer> result = new ArrayList<>();
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (maps[i].charAt(j) == 'X' || visited[i][j]) {
					continue;
				}
				result.add(bfs(maps, i, j));
			}
		}
		if (result.isEmpty()) {
			return new int[] {-1};
		}

		result.sort(null);
		int[] answer = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}
		return answer;
	}

	private Integer bfs(final String[] maps, final int r, final int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r, c));
		visited[r][c] = true;

		int sum = 0;
		while (!queue.isEmpty()) {
			Point current = queue.poll();
			char currentValue = maps[current.r].charAt(current.c);
			sum += Character.getNumericValue(currentValue);

			for (int i = 0; i < 4; i++) {
				int newR = current.r + nR[i];
				int newC = current.c + nC[i];

				if (newR < 0 || newC < 0 || newR >= N || newC >= M) {
					continue;
				}
				if (maps[newR].charAt(newC) == 'X' || visited[newR][newC]) {
					continue;
				}
				visited[newR][newC] = true;

				queue.add(new Point(newR, newC));
			}
		}

		return sum;
	}

	private class Point {
		int r;
		int c;

		public Point(final int r, final int c) {
			this.r = r;
			this.c = c;
		}
	}

}
