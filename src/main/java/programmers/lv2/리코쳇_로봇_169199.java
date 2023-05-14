package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇_로봇_169199 {
	private int N, M;

	private int[] nR = {-1, 0, 1, 0};
	private int[] nC = {0, -1, 0, 1};

	public int solution(String[] board) {
		N = board.length;
		M = board[0].length();

		return bfs(board);
	}

	private int bfs(final String[] board) {
		Robot robot = findRobot(board);
		Queue<Robot> queue = new LinkedList<>();
		queue.add(robot);

		boolean[][] visited = new boolean[N][M];
		visited[robot.r][robot.c] = true;

		while (!queue.isEmpty()) {
			Robot current = queue.poll();
			int currentR = current.r;
			int currentC = current.c;

			for (int i = 0; i < 4; i++) {
				int nextR = current.r + nR[i];
				int nextC = current.c + nC[i];

				while (isInBoundary(nextR, nextC) && isNotBlock(board, nextR, nextC)) {
					currentR = nextR;
					currentC = nextC;
					nextR += nR[i];
					nextC += nC[i];
				}

				if (visited[currentR][currentC]) {
					continue;
				}
				visited[currentR][currentC] = true;

				if (board[currentR].charAt(currentC) == 'G') {
					return current.count + 1;
				}
				queue.add(new Robot(currentR, currentC, current.count + 1));
			}
		}
		return -1;
	}

	private boolean isNotBlock(final String[] board, final int r, final int c) {
		return board[r].charAt(c) != 'D';
	}

	private boolean isInBoundary(final int r, final int c) {
		return r < N && c < M && r >= 0 && c >= 0;
	}

	private Robot findRobot(final String[] board) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i].charAt(j) == 'R') {
					return new Robot(i, j, 0);
				}
			}
		}
		throw new IllegalArgumentException("Can`t find robot");
	}

	private static class Robot {
		int r;
		int c;
		int count;

		public Robot(final int r, final int c, final int count) {
			this.r = r;
			this.c = c;
			this.count = count;
		}
	}
}
