package programmers.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 합승_택시_요금_72413 {

	private int N;
	private List<List<Node>> graph;

	public int solution(int n, int s, int a, int b, int[][] fares) {
		N = n;
		initGraph(n, fares);

		int[] minCostFromS = bfs(s);
		int[] minCostFromA = bfs(a);
		int[] minCostFromB = bfs(b);

		int minCost = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			minCost = Math.min(minCost, minCostFromS[i] + minCostFromA[i] + minCostFromB[i]);
		}

		return minCost;
	}

	private int[] bfs(final int start) {
		boolean[] visited = new boolean[N + 1];
		int[] dist = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node current = pq.poll();

			if (visited[current.destination]) {
				continue;
			}
			visited[current.destination] = true;

			for (Node next : graph.get(current.destination)) {
				if (visited[next.destination] || dist[next.destination] <= dist[current.destination] + next.cost) {
					continue;
				}
				dist[next.destination] = dist[current.destination] + next.cost;
				pq.add(new Node(next.destination, dist[next.destination]));
			}
		}

		return dist;
	}

	private void initGraph(final int n, final int[][] fares) {
		graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] fare : fares) {
			int start = fare[0];
			int end = fare[1];
			int cost = fare[2];

			graph.get(start).add(new Node(end, cost));
			graph.get(end).add(new Node(start, cost));
		}
	}

	private class Node implements Comparable<Node> {
		int destination;
		int cost;

		public Node(final int destination, final int cost) {
			this.destination = destination;
			this.cost = cost;
		}

		@Override
		public int compareTo(final Node o) {
			return this.cost - o.cost;
		}
	}
}
