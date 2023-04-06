package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//TODO
public class RGB거리_2_17404 {

	static final int INF = 1_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][3];
		int[][] homes = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			homes[i][0] = Integer.parseInt(st.nextToken());
			homes[i][1] = Integer.parseInt(st.nextToken());
			homes[i][2] = Integer.parseInt(st.nextToken());
		}

		int result = Integer.MAX_VALUE;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j) {
					dp[1][j] = homes[1][j];
				} else {
					dp[1][j] = INF;
				}
			}

			for (int k = 2; k <= N; k++) {
				dp[k][0] = Math.min(dp[k - 1][1], dp[k - 1][2]) + homes[k][0];
				dp[k][1] = Math.min(dp[k - 1][0], dp[k - 1][2]) + homes[k][1];
				dp[k][2] = Math.min(dp[k - 1][0], dp[k - 1][1]) + homes[k][2];
			}

			for (int j = 0; j < 3; j++) {
				if (i != j) {
					result = Math.min(result, dp[N][j]);
				}
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}
}
