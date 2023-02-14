package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

//TODO
public class N과_M_9_15663 {

	static int N;
	static int M;
	static int[] numbers;
	static int[] result;
	static boolean[] visited;
	static Set<String> sequences;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		result = new int[M];
		visited = new boolean[N];
		sequences = new LinkedHashSet<>();

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(numbers);

		dfs(0, 0);

		System.out.print(String.join(System.lineSeparator(), sequences));
	}

	private static void dfs(int start, int count) {
		if (count == M) {
			String sequence = "";
			for (int number : result) {
				sequence = sequence.concat(number + " ");
			}
			sequences.add(sequence);
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
