package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 사이클_게임_20040 {

	static int n, m;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		int count = 0;

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			if (hasSameParent(start, end)) {
				count = i;
				break;
			} else {
				union(start, end);
			}
		}

		bw.write(String.valueOf(count));
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

}
