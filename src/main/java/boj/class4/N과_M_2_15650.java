package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과_M_2_15650 {

	static int N;
	static int M;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();

		dfs(1, "");

		System.out.print(sb);
	}

	private static void dfs(int start, String sequence) {
		if (sequence.length() == M) {
			String[] split = sequence.split("");
			sb.append(String.join(" ", split)).append(System.lineSeparator());
			return;
		}
		for (int i = start; i <= N; i++) {
			dfs(i + 1, sequence + i);
		}
	}
}
