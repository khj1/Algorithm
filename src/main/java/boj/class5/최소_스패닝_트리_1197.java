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

//TODO
//크루스칼 알고리즘 기본
public class 최소_스패닝_트리_1197 {

	static int V, E;
	static int[] parent;
	static List<Node> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list.add(new Node(start, end, cost));
		}

		Collections.sort(list);

		int sum = 0;
		for (Node node : list) {
			if (!hasSameParent(node.start, node.end)) {
				sum += node.cost;
				union(node.start, node.end);
			}
		}

		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
		br.close();
	}

	private static boolean hasSameParent(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b) {
			return true;
		}
		return false;
	}

	private static int find(final int n) {
		if (parent[n] == n) {
			return n;
		}
		parent[n] = find(parent[n]);
		return parent[n];
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parent[b] = a;
		}
	}

	static class Node implements Comparable<Node> {
		int start;
		int end;
		int cost;

		public Node(final int start, final int end, final int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(final Node o) {
			return this.cost - o.cost;
		}
	}
}
