package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//TODO
public class 행렬_곱셈_순서_11049 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][N];
		int[][] map = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int k = 1; k < N; k++) {
			for (int i = 0; i + k < N; i++) {
				dp[i][i + k] = Integer.MAX_VALUE;
				for (int j = i; j < i + k; j++)
					dp[i][i + k] = Math.min(dp[i][i + k],
							dp[i][j] + dp[j + 1][i + k] + map[i][0] * map[j][1] * map[i + k][1]);
			}
		}

		bw.write(String.valueOf(dp[0][N - 1]));
		bw.flush();
		bw.close();
		br.close();
	}

}
