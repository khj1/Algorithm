package programmers.lv3;

import java.util.ArrayDeque;
import java.util.Queue;

//TODO
public class 미로_탈출_명령어_150365 {

	private final String[] direction = {"d", "l", "r", "u"};
	private final int[] nX = {1, 0, 0, -1};
	private final int[] nY = {0, -1, 1, 0};

	public String solution(int n, int m, int x, int y, int r, int c, int k) {
		boolean[][][] visited = new boolean[n][m][k + 1];
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(x - 1, y - 1, new StringBuilder()));
		visited[x - 1][y - 1][0] = true;

		while (!queue.isEmpty()) {
			Point current = queue.poll();
			StringBuilder currentDirections = current.sb;

			if (currentDirections.length() == k) {
				if (current.x == r - 1 && current.y == c - 1) {
					return currentDirections.toString();
				}
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = current.x + nX[i];
				int nextY = current.y + nY[i];
				StringBuilder nextDirections = new StringBuilder(currentDirections).append(direction[i]);

				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
					continue;
				}
				if (visited[nextX][nextY][nextDirections.length()]) {
					continue;
				}
				visited[nextX][nextY][nextDirections.length()] = true;

				queue.add(new Point(nextX, nextY, nextDirections));
			}
		}

		return "impossible";
	}

	private class Point {
		int x;
		int y;
		StringBuilder sb;

		public Point(final int x, final int y, final StringBuilder sb) {
			this.x = x;
			this.y = y;
			this.sb = sb;
		}
	}
}
