package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 문제집_1766 {

	static int N, M;
	static int[] count;
	static List<Integer>[] orders;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		count = new int[N + 1];
		orders = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			orders[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int prev = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());

			orders[prev].add(next);
			count[next]++;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if (count[i] == 0) {
				pq.add(i);
			}
		}

		while (!pq.isEmpty()) {
			int current = pq.poll();
			sb.append(current).append(" ");

			for (int next : orders[current]) {
				count[next]--;
				if (count[next] == 0) {
					pq.add(next);
				}
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
