package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_2178 {

	private static final int[] NX = {0, -1, 0, 1};
	private static final int[] NY = {-1, 0, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] maze = new int[N][M];
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(split[j]);
			}
		}
		System.out.println(bfs(maze, visited, N, M));
	}

	private static int bfs(int[][] maze, boolean[][] visited, int n, int m) {
		Queue<Block> queue = new LinkedList<>();
		queue.add(new Block(0, 0, 1));

		int count = 0;
		while (!queue.isEmpty()) {
			Block block = queue.poll();
			if (block.isDestination(n, m)) {
				count = block.count;
				break;
			} else {
				for (int i = 0; i < 4; i++) {
					int nx = block.x + NX[i];
					int ny = block.y + NY[i];

					if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1) {
						continue;
					}
					if (visited[nx][ny] || maze[nx][ny] == 0) {
						continue;
					}
					visited[nx][ny] = true;
					queue.add(new Block(nx, ny, block.count + 1));
				}
			}
		}
		return count;
	}

	private static class Block {
		int x;
		int y;
		int count;

		public Block(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}

		public boolean isDestination(int n, int m) {
			return x == n - 1 && y == m - 1;
		}
	}
}
