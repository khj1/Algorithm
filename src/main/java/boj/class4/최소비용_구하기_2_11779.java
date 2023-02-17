package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용_구하기_2_11779 {

	static int n;
	static int m;
	static List<List<Node>> network;
	static int[] minCost;
	static List<List<Integer>> minPath;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		network = initNetwork(br);
		minCost = new int[n + 1];
		minPath = initMinPath();

		Arrays.fill(minCost, Integer.MAX_VALUE);

		StringTokenizer st = new StringTokenizer(br.readLine());
		int departure = Integer.parseInt(st.nextToken());
		int destination = Integer.parseInt(st.nextToken());

		dijkstra(departure);

		sb.append(minCost[destination]).append(System.lineSeparator());
		sb.append(minPath.get(destination).size()).append(System.lineSeparator());
		for (Integer node : minPath.get(destination)) {
			sb.append(node).append(" ");
		}

		System.out.println(sb);
	}

	private static List<List<Node>> initNetwork(BufferedReader br) throws IOException {
		List<List<Node>> network = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			network.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			network.get(start).add(new Node(end, cost));
		}

		return network;
	}

	private static List<List<Integer>> initMinPath() {
		List<List<Integer>> network = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			network.add(new ArrayList<>());
		}
		return network;
	}

	private static void dijkstra(int departure) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n + 1];
		minCost[departure] = 0;
		minPath.get(departure).add(departure);
		pq.add(new Node(departure, 0));

		while (!pq.isEmpty()) {
			int currentPosition = pq.poll().destination;
			if (visited[currentPosition]) {
				continue;
			}
			visited[currentPosition] = true;

			for (Node node : network.get(currentPosition)) {
				int nextPosition = node.destination;
				int nextCost = node.cost;
				if (visited[nextPosition] || minCost[nextPosition] <= minCost[currentPosition] + nextCost) {
					continue;
				}
				minCost[nextPosition] = minCost[currentPosition] + nextCost;

				List<Integer> nextPath = minPath.get(nextPosition);
				nextPath.clear();
				nextPath.addAll(minPath.get(currentPosition));
				nextPath.add(nextPosition);

				pq.add(new Node(nextPosition, minCost[nextPosition]));
			}
		}
	}

	static class Node implements Comparable<Node> {
		int destination;
		int cost;

		public Node(int destination, int cost) {
			this.destination = destination;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}
