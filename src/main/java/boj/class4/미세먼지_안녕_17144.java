package boj.class4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미세먼지_안녕_17144 {

	static int R, C, T;
	static int[][] map;
	static List<Integer> cleaner;

	static int[] nR = {-1, 0, 1, 0};
	static int[] nC = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R + 1][C + 1];
		cleaner = new ArrayList<>();

		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == -1) {
					cleaner.add(i);
				}
				map[i][j] = value;
			}
		}

		for (int i = 0; i < T; i++) {
			diffuse();
			clean();
		}

		int totalAmount = 0;
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] > 0) {
					totalAmount += map[i][j];
				}
			}
		}

		bw.write(String.valueOf(totalAmount));
		bw.flush();
		bw.close();
		br.close();
	}

	private static void diffuse() {
		int[][] tempMap = new int[R + 1][C + 1];
		Queue<Dust> queue = new LinkedList<>();
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] > 0) {
					queue.add(new Dust(i, j, map[i][j]));
				}
			}
		}

		while (!queue.isEmpty()) {
			Dust dust = queue.poll();

			for (int i = 0; i < 4; i++) {
				int newR = dust.r + nR[i];
				int newC = dust.c + nC[i];

				if (newR < 1 || newC < 1 || newR > R || newC > C) {
					continue;
				}
				if (map[newR][newC] == -1) {
					continue;
				}
				tempMap[newR][newC] += dust.diffuse();
			}

			tempMap[dust.r][dust.c] += dust.calculateRemain();
		}

		map = tempMap;
	}

	private static void clean() {
		int[][] tempMap = new int[R + 1][C + 1];
		int upperIndex = cleaner.get(0);
		int lowerIndex = cleaner.get(1);

		tempMap[upperIndex][1] = -1;
		tempMap[lowerIndex][1] = -1;

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if ((i == upperIndex || i == lowerIndex) && j > 1 && j < C) {
					tempMap[i][j + 1] = map[i][j];
				} else if ((i == 1 || i == R) && j > 1) {
					tempMap[i][j - 1] = map[i][j];
				} else if (j == C) {
					if (i <= upperIndex) {
						tempMap[i - 1][j] = map[i][j];
					}
					if (i >= lowerIndex) {
						tempMap[i + 1][j] = map[i][j];
					}
				} else if (j == 1) {
					if (i < upperIndex - 1) {
						tempMap[i + 1][j] = map[i][j];
					}
					if (i > lowerIndex + 1) {
						tempMap[i - 1][j] = map[i][j];
					}
				} else {
					tempMap[i][j] = map[i][j];
				}
			}
		}
		map = tempMap;
	}

	private static class Dust {
		int r;
		int c;
		int amount;
		int diffuseCount = 0;

		public Dust(final int r, final int c, final int amount) {
			this.r = r;
			this.c = c;
			this.amount = amount;
		}

		public int diffuse() {
			diffuseCount++;
			return amount / 5;
		}

		public int calculateRemain() {
			return amount - (amount / 5 * diffuseCount);
		}
	}
}
