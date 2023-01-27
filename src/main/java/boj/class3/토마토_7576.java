package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TODO
public class 토마토_7576 {

	private static int N;
	private static int M;
	private static int maxDay = Integer.MIN_VALUE;
	private static int[] nX = {-1, 0, 1, 0};
	private static int[] nY = {0, -1, 0, 1};
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st1.nextToken());
		N = Integer.parseInt(st1.nextToken());

		visited = new boolean[N][M];
		int[][] field = new int[N][M];
		Queue<Tomato> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				field[i][j] = Integer.parseInt(st2.nextToken());
				if (field[i][j] == 1) {
					queue.add(new Tomato(i, j, 0));
				}
			}
		}
		bfs(field, queue);

		if (!isAllRipens(field)) {
			System.out.println(-1);
		} else if (maxDay == Integer.MIN_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(maxDay);
		}
	}

	private static void bfs(int[][] field, Queue<Tomato> queue) {
		while (!queue.isEmpty()) {
			Tomato tomato = queue.poll();
			for (int k = 0; k < 4; k++) {
				int newX = tomato.x + nX[k];
				int newY = tomato.y + nY[k];
				int newDay = tomato.day + 1;

				if (newX < 0 || newY < 0 || newX >= N || newY >= M) {
					continue;
				}
				if (field[newX][newY] == 1 || field[newX][newY] == -1 || visited[newX][newY]) {
					continue;
				}
				field[newX][newY] = 1;
				visited[newX][newY] = true;
				maxDay = Math.max(maxDay, newDay);
				queue.add(new Tomato(newX, newY, newDay));
			}
		}
	}

	private static boolean isAllRipens(int[][] field) {
		for (int[] tomatoes : field) {
			for (int tomato : tomatoes) {
				if (tomato == 0) {
					return false;
				}
			}
		}
		return true;
	}

	static class Tomato {
		int x;
		int y;
		int day;

		public Tomato(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
}
