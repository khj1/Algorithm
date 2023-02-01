package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO
public class 구간_합_구하기_4_11659 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stA = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stA.nextToken());
		int M = Integer.parseInt(stA.nextToken());

		StringTokenizer stB = new StringTokenizer(br.readLine());
		int[] numbers = new int[N + 1];
		int[] sum = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			numbers[i] = Integer.parseInt(stB.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i - 1] + numbers[i];
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer stC = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(stC.nextToken());
			int end = Integer.parseInt(stC.nextToken());

			sb.append(sum[end] - sum[start - 1]).append("\n");
		}
		System.out.print(sb);
	}
}
