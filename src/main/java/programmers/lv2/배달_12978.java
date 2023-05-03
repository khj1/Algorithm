package programmers.lv2;

import java.util.Arrays;

public class 배달_12978 {

	private static final int INF = 500_001;

	public int solution(int N, int[][] road, int K) {
		int[][] minTimes = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(minTimes[i], INF);
		}
		for (int i = 1; i <= N; i++) {
			minTimes[i][i] = 0;
		}

		for (int[] info : road) {
			int start = info[0];
			int end = info[1];
			int cost = info[2];

			minTimes[start][end] = Math.min(minTimes[start][end], cost);
			minTimes[end][start] = Math.min(minTimes[end][start], cost);
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					minTimes[i][j] = Math.min(minTimes[i][j], minTimes[i][k] + minTimes[k][j]);
				}
			}
		}

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (minTimes[1][i] <= K) {
				answer++;
			}
		}
		return answer;
	}
}
