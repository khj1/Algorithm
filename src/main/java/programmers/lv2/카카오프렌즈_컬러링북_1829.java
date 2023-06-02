package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈_컬러링북_1829 {
	private int[] nR = {-1, 0, 1, 0};
	private int[] nC = {0, -1, 0, 1};

	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] == 0 || visited[i][j]) {
					continue;
				}
				visited[i][j] = true;
				int sizeOfArea = bfs(picture, visited, i, j);
				maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfArea);
				numberOfArea++;
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	private int bfs(final int[][] picture, final boolean[][] visited, final int r, final int c) {
		int currentColor = picture[r][c];
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r, c));

		int sizeOfArea = 1;
		while (!queue.isEmpty()) {
			Point currentPoint = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newR = currentPoint.r + nR[i];
				int newC = currentPoint.c + nC[i];

				if (newR < 0 || newC < 0 || newR >= picture.length || newC >= picture[0].length) {
					continue;
				}
				if (visited[newR][newC] || picture[newR][newC] != currentColor) {
					continue;
				}
				visited[newR][newC] = true;
				sizeOfArea++;
				queue.add(new Point(newR, newC));
			}
		}

		return sizeOfArea;
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
