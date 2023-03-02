package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 서강그라운드_14938 {

	static int n;
	static int m;
	static int r;
	static int[] items;
	static int[][] minDist;
	static int max = Integer.MIN_VALUE;

	static final int INF = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		items = new int[n + 1];
		minDist = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				minDist[i][j] = INF;
			}
		}

		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			items[i] = Integer.parseInt(st2.nextToken());
		}

		for (int i = 0; i < r; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st3.nextToken());
			int b = Integer.parseInt(st3.nextToken());
			int l = Integer.parseInt(st3.nextToken());

			minDist[a][b] = l;
			minDist[b][a] = l;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					minDist[i][j] = Math.min(minDist[i][j], minDist[i][k] + minDist[k][j]);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			int sum = items[i];
			for (int j = 1; j <= n; j++) {
				if (i == j || minDist[i][j] > m) {
					continue;
				}
				sum += items[j];
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

}
