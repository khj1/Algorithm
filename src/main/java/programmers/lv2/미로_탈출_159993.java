package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 미로_탈출_159993 {

	private int N;
	private int M;
	private char[][] maze;
	private int[] nR = {-1, 0, 1, 0};
	private int[] nC = {0, -1, 0, 1};

	public int solution(String[] maps) {
		N = maps.length;
		M = maps[0].length();

		maze = new char[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				char character = maps[i].charAt(j);
				maze[i][j] = character;
			}
		}
		return bfs();
	}

	private int bfs() {
		boolean[][] visitedBeforePulled = new boolean[N][M];
		boolean[][] visitedAfterPulled = new boolean[N][M];
		Queue<Player> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (maze[i][j] == 'S') {
					visitedBeforePulled[i][j] = true;
					queue.add(new Player(i, j, 0, false));
				}
			}
		}

		while (!queue.isEmpty()) {
			Player current = queue.poll();
			if (maze[current.r][current.c] == 'E' && current.hasPulledLever) {
				return current.time;
			}
			if (maze[current.r][current.c] == 'L' && !current.hasPulledLever) {
				current.pullLever();
			}
			for (int i = 0; i < 4; i++) {
				int newR = current.r + nR[i];
				int newC = current.c + nC[i];

				if (newR < 0 || newC < 0 || newR >= N || newC >= M) {
					continue;
				}
				if (maze[newR][newC] == 'X') {
					continue;
				}
				if (!current.hasPulledLever && visitedBeforePulled[newR][newC]) {
					continue;
				}
				if (current.hasPulledLever && visitedAfterPulled[newR][newC]) {
					continue;
				}
				if (current.hasPulledLever) {
					visitedAfterPulled[newR][newC] = true;
				} else {
					visitedBeforePulled[newR][newC] = true;
				}
				queue.add(new Player(newR, newC, current.time + 1, current.hasPulledLever));
			}
		}
		return -1;
	}

	private class Player {
		int r;
		int c;
		int time;
		boolean hasPulledLever;

		public Player(final int r, final int c, final int time, final boolean hasPulledLever) {
			this.r = r;
			this.c = c;
			this.time = time;
			this.hasPulledLever = hasPulledLever;
		}

		public void pullLever() {
			hasPulledLever = true;
		}
	}
}
