package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과_M_8_15657 {

	static int N;
	static int M;
	static int[] numbers;
	static int[] result;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[N];
		result = new int[M];
		sb = new StringBuilder();

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(numbers);

		dfs(0, 0);

		System.out.print(sb);
	}

	private static void dfs(int start, int count) {
		if (count == M) {
			for (int number : result) {
				sb.append(number).append(" ");
			}
			sb.append(System.lineSeparator());
			return;
		}
		for (int i = start; i < N; i++) {
			result[count] = numbers[i];
			dfs(i, count + 1);
		}
	}
}
