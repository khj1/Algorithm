package programmers.lv3;

import java.util.ArrayList;
import java.util.List;

public class 섬_연결하기_42861 {
	private int[] parent;
	private List<Node> nodes;

	public int solution(int n, int[][] costs) {
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		nodes = new ArrayList<>();

		for (int[] cost : costs) {
			nodes.add(new Node(cost[0], cost[1], cost[2]));
			nodes.add(new Node(cost[1], cost[0], cost[2]));
		}
		nodes.sort(null);

		int answer = 0;
		for (Node node : nodes) {
			int start = node.start;
			int end = node.end;
			int cost = node.cost;

			if (find(start) != find(end)) {
				union(start, end);
				answer += cost;
			}
		}

		return answer;
	}

	private int find(final int n) {
		if (parent[n] == n) {
			return n;
		}
		return parent[n] = find(parent[n]);
	}

	private void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parent[b] = a;
		}
	}

	private static class Node implements Comparable<Node> {
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
