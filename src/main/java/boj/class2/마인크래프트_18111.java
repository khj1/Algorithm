package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO
public class 마인크래프트_18111 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		int B = Integer.parseInt(st1.nextToken());

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int[][] ground = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st2.nextToken());
				min = Math.min(min, value);
				max = Math.max(max, value);
				ground[i][j] = value;
			}
		}

		int minTime = Integer.MAX_VALUE;
		int optimalHeight = 0;
		for (int targetHeight = min; targetHeight <= max; targetHeight++) {
			int time = 0;
			int currentBlock = B;
			for (int[] row : ground) {
				for (int currentHeight : row) {
					if (currentHeight > targetHeight) {
						currentBlock += currentHeight - targetHeight;
						time += (currentHeight - targetHeight) * 2;
					} else if (currentHeight < targetHeight) {
						currentBlock -= targetHeight - currentHeight;
						time += targetHeight - currentHeight;
					}
				}
			}
			if (currentBlock < 0) {
				time = Integer.MAX_VALUE;
			} else if (minTime > time) {
				minTime = time;
				optimalHeight = targetHeight;
			} else if (minTime == time) {
				optimalHeight = Math.max(optimalHeight, targetHeight);
			}
		}
		System.out.println(minTime + " " + optimalHeight);
	}
}
