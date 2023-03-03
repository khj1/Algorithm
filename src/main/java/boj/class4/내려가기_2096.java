package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO
public class 내려가기_2096 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] numbers = new int[4];
		int[] maxDp = new int[4];
		int[] minDp = new int[4];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			numbers[1] = Integer.parseInt(st.nextToken());
			numbers[2] = Integer.parseInt(st.nextToken());
			numbers[3] = Integer.parseInt(st.nextToken());

			if (i == 0) {
				maxDp[1] = numbers[1];
				maxDp[2] = numbers[2];
				maxDp[3] = numbers[3];

				minDp[1] = numbers[1];
				minDp[2] = numbers[2];
				minDp[3] = numbers[3];

				continue;
			}

			int[] tempMax = new int[4];
			int[] tempMin = new int[4];

			tempMax[1] = Math.max(maxDp[1], maxDp[2]) + numbers[1];
			tempMax[2] = Math.max(Math.max(maxDp[1], maxDp[2]), maxDp[3]) + numbers[2];
			tempMax[3] = Math.max(maxDp[2], maxDp[3]) + numbers[3];

			tempMin[1] = Math.min(minDp[1], minDp[2]) + numbers[1];
			tempMin[2] = Math.min(Math.min(minDp[1], minDp[2]), minDp[3]) + numbers[2];
			tempMin[3] = Math.min(minDp[2], minDp[3]) + numbers[3];

			maxDp = tempMax;
			minDp = tempMin;
		}

		int maxResult = Integer.MIN_VALUE;
		for (int i = 1; i <= 3; i++) {
			maxResult = Math.max(maxResult, maxDp[i]);
		}

		int minResult = Integer.MAX_VALUE;
		for (int i = 1; i <= 3; i++) {
			minResult = Math.min(minResult, minDp[i]);
		}

		System.out.println(maxResult + " " + minResult);
	}
}

