package programmers.lv3;

import java.util.LinkedList;
import java.util.Queue;

//TODO
public class 경주로_건설_67259 {

	public static final int CORNER_COST = 500;
	public static final int STRAIGHT_COST = 100;

	private int[] dx = {1, 0, -1, 0};
	private int[] dy = {0, 1, 0, -1};
	private int[][][] dp;
	private int N;

	public int solution(int[][] board) {
		N = board.length;
		dp = new int[N][N][4];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 4; k++) {
					dp[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			dp[0][0][i] = 0;
		}

		bfs(board);

		int minCost = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++) {
			minCost = Math.min(minCost, dp[N - 1][N - 1][i]);
		}

		return minCost;
	}

	private void bfs(final int[][] board) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0, 0));

		while (!queue.isEmpty()) {
			Point current = queue.poll();
			int currentX = current.x;
			int currentY = current.y;
			int dir = current.direction;

			for (int i = 0; i < 4; i++) {
				int nextX = currentX + dx[i];
				int nextY = currentY + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
					continue;
				}
				if (board[nextX][nextY] == 1) {
					continue;
				}

				int cost = dp[currentX][currentY][dir];
				if ((currentX == 0 && currentY == 0) || i == dir) {
					cost += STRAIGHT_COST;
				} else {
					cost += CORNER_COST + STRAIGHT_COST;
				}

				if (dp[nextX][nextY][i] > cost) {
					dp[nextX][nextY][i] = cost;
					queue.add(new Point(nextX, nextY, i));
				}
			}
		}
	}

	private class Point {
		int x;
		int y;
		int direction;

		public Point(final int x, final int y, final int direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
	}

}
