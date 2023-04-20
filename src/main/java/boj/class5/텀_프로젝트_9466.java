package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//TODO
public class 텀_프로젝트_9466 {

	static int[] students;
	static boolean[] visited, finished;
	static int totalCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			students = new int[n + 1];

			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				students[j] = Integer.parseInt(st.nextToken());
			}

			visited = new boolean[n + 1];
			finished = new boolean[n + 1];
			totalCount = 0;

			for (int j = 1; j <= n; j++) {
				dfs(j);
			}
			bw.write(n - totalCount + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(final int current) {
		visited[current] = true;
		int next = students[current];

		if (!visited[next]) {
			dfs(next);
		} else {
			if (!finished[next]) {
				totalCount++;
				while (next != current) {
					totalCount++;
					next = students[next];
				}
			}
		}
		finished[current] = true;
	}
}
