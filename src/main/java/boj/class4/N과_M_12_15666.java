package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N과_M_12_15666 {

	static int N;
	static int M;
	static int[] numbers;
	static int[] result;
	static Set<String> sequences;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		result = new int[M];
		sequences = new LinkedHashSet<>();

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(numbers);

		dfs(0, 0);

		System.out.print(String.join("\n", sequences));
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
			result[count] = numbers[i];
			dfs(i, count + 1);
		}
	}
}
