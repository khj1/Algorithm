package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음악프로그램_2623 {

	static int N, M;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		List<Integer>[] singers = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			singers[i] = new ArrayList<>();
		}

		int[] count = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int singerCount = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			for (int j = 0; j < singerCount - 1; j++) {
				int next = Integer.parseInt(st.nextToken());
				singers[prev].add(next);
				count[next]++;
				prev = next;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (count[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current).append(System.lineSeparator());

			for (int next : singers[current]) {
				count[next]--;
				if (count[next] == 0) {
					queue.add(next);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (count[i] > 0) {
				sb = new StringBuilder();
				sb.append(0);
				break;
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
