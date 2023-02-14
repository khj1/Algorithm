package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과_M_5_15654 {

	static int N;
	static int M;
	static int[] numbers;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[N];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(numbers);

		result = new int[M];
		visited = new boolean[N];
		sb = new StringBuilder();

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
			if (visited[i]) {
				continue;
			}
			result[count] = numbers[i];

			visited[i] = true;
			dfs(start, count + 1);
			visited[i] = false;
		}
	}
}
