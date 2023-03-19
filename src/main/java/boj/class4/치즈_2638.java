package boj.class4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈_2638 {

	static int N, M;
	static int time = 0;
	static int[] nR = {-1, 0, 1, 0};
	static int[] nC = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] cheeses = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				cheeses[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (!isAllClear(cheeses)) {
			time++;
			checkOutsideAir(cheeses);
			cheeses = meltCheese(cheeses);
		}

		bw.write(String.valueOf(time));
		bw.flush();
		bw.close();
		br.close();
	}

	private static void checkOutsideAir(final int[][] cheeses) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (cheeses[i][j] == 0) {
					cheeses[i][j] = -1;
				}
			}
		}

		Queue<Air> queue = new LinkedList<>();
		queue.add(new Air(0, 0));
		cheeses[0][0] = 0;

		while (!queue.isEmpty()) {
			Air current = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newR = current.r + nR[i];
				int newC = current.c + nC[i];

				if (newR < 0 || newC < 0 || newR >= N || newC >= M) {
					continue;
				}
				if (cheeses[newR][newC] == 1 || cheeses[newR][newC] == 0) {
					continue;
				}
				cheeses[newR][newC] = 0;
				queue.add(new Air(newR, newC));
			}
		}
	}

	private static int[][] meltCheese(final int[][] cheeses) {
		Queue<Cheese> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (cheeses[i][j] == 1) {
					queue.add(new Cheese(i, j));
				}
			}
		}

		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			temp[i] = cheeses[i].clone();
		}

		while (!queue.isEmpty()) {
			Cheese current = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newR = current.r + nR[i];
				int newC = current.c + nC[i];

				if (newR < 0 || newC < 0 || newR >= N || newC >= M) {
					continue;
				}
				if (cheeses[newR][newC] == 1 || cheeses[newR][newC] == -1) {
					continue;
				}
				current.contactCount++;
			}

			if (current.contactCount >= 2) {
				temp[current.r][current.c] = 0;
			}
		}
		return temp;
	}

	private static boolean isAllClear(final int[][] cheeses) {
		for (int[] row : cheeses) {
			for (int cheese : row) {
				if (cheese == 1) {
					return false;
				}
			}
		}
		return true;
	}

	static class Air {
		int r;
		int c;

		public Air(final int r, final int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Cheese {
		int r;
		int c;
		int contactCount = 0;

		public Cheese(final int r, final int c) {
			this.r = r;
			this.c = c;
		}
	}

}
