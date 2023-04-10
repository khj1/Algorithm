package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//TODO
public class 앱_7579 {

	public static final int INF = 100_001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] m = new int[N + 1];
		int[] c = new int[N + 1];
		int[][] dp = new int[N + 1][INF];

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			m[i] = Integer.parseInt(st1.nextToken());
			c[i] = Integer.parseInt(st2.nextToken());
		}

		int minCost = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < INF; j++) {
				if (j < c[i]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - c[i]] + m[i], dp[i - 1][j]);
				}
			}
		}

		for (int i = 1; i < INF; i++) {
			if (dp[N][i] >= M) {
				minCost = i;
				break;
			}
		}

		bw.write(String.valueOf(minCost));
		bw.flush();
		bw.close();
		br.close();
	}

}
