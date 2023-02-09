package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TODO
public class 토마토_7569 {

	static int[] nH = {0, 0, 0, 0, -1, 1};
	static int[] nR = {-1, 0, 1, 0, 0, 0};
	static int[] nC = {0, 1, 0, -1, 0, 0};

	static int M;
	static int N;
	static int H;
	static int count = 0;
	static int[][][] layersOfTomatoes;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		visited = new boolean[H][N][M];
		layersOfTomatoes = new int[H][N][M];
		Queue<Tomato> queue = new LinkedList<>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					int tomato = Integer.parseInt(st2.nextToken());
					if (tomato == 1) {
						queue.add(new Tomato(i, j, k, 0));
					}
					layersOfTomatoes[i][j][k] = tomato;
				}
			}
		}
		bfs(queue);

		if (isAllRipen(layersOfTomatoes)) {
			System.out.println(count);
		} else {
			System.out.println(-1);
		}
	}

	private static void bfs(Queue<Tomato> queue) {
		while (!queue.isEmpty()) {
			Tomato current = queue.poll();

			for (int i = 0; i < 6; i++) {
				int newH = current.h + nH[i];
				int newR = current.r + nR[i];
				int newC = current.c + nC[i];
				int newCount = current.count + 1;

				if (newH < 0 || newR < 0 || newC < 0) {
					continue;
				}
				if (newH >= H || newR >= N || newC >= M) {
					continue;
				}
				if (visited[newH][newR][newC] || layersOfTomatoes[newH][newR][newC] != 0) {
					continue;
				}
				visited[newH][newR][newC] = true;
				layersOfTomatoes[newH][newR][newC] = 1;
				count = Math.max(count, newCount);
				queue.add(new Tomato(newH, newR, newC, newCount));
			}
		}
	}

	private static boolean isAllRipen(int[][][] layersOfTomatoes) {
		for (int[][] layer : layersOfTomatoes) {
			for (int[] tomatoes : layer) {
				for (int tomato : tomatoes) {
					if (tomato == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

	static class Tomato {
		int h;
		int r;
		int c;
		int count;

		public Tomato(int h, int r, int c, int count) {
			this.h = h;
			this.r = r;
			this.c = c;
			this.count = count;
		}
	}
}
