package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농_배추_1012 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st1.nextToken());
			int N = Integer.parseInt(st1.nextToken());

			int[][] field = new int[N][M];

			int K = Integer.parseInt(st1.nextToken());

			for (int j = 0; j < K; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
				int y = Integer.parseInt(st2.nextToken());
				int x = Integer.parseInt(st2.nextToken());

				field[x][y] = 1;
			}

			int wormCount = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (field[j][k] == 1) {
						wormCount++;
						dps(field, j, k);
					}
				}
			}
			System.out.println(wormCount);
		}
	}

	private static void dps(int[][] field, int j, int k) {
		if (j < 0 || k < 0 || j >= field.length || k >= field[0].length) {
			return;
		}
		if (field[j][k] == 1) {
			field[j][k] = 0;
			dps(field, j - 1, k);
			dps(field, j + 1, k);
			dps(field, j, k - 1);
			dps(field, j, k + 1);
		}
	}
}
