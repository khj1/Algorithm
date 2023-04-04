package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 도시_분할_계획_1647 {

	static int N, M;
	static int[] parent;
	static List<Path> paths = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			paths.add(new Path(start, end, cost));
		}

		Collections.sort(paths);

		int sum = 0;
		int maxCost = 0;
		for (Path path : paths) {
			if (!hasSameParent(path.start, path.end)) {
				sum += path.cost;
				union(path.start, path.end);

				maxCost = path.cost;
			}
		}

		bw.write(String.valueOf(sum - maxCost));
		bw.flush();
		bw.close();
		br.close();
	}

	private static boolean hasSameParent(final int a, final int b) {
		return find(a) == find(b);
	}

	private static int find(final int n) {
		if (parent[n] == n) {
			return n;
		}
		return parent[n] = find(parent[n]);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parent[b] = a;
		}
	}

	private static class Path implements Comparable<Path> {
		int start;
		int end;
		int cost;

		public Path(final int start, final int end, final int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(final Path o) {
			return this.cost - o.cost;
		}
	}

}
