package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//TODO
public class 트리의_지름_1167 {

	static int V;
	static List<List<Node>> tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());

		tree = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			tree.add(new ArrayList<>());
		}

		for (int i = 1; i <= V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int departure = Integer.parseInt(st.nextToken());
			while (true) {
				int destination = Integer.parseInt(st.nextToken());
				if (destination == -1) {
					break;
				}
				int cost = Integer.parseInt(st.nextToken());
				tree.get(departure).add(new Node(destination, cost));
			}
		}
		int max = Integer.MIN_VALUE;
		int maxNode = -1;
		int[] maxNodes = dijkstra(1);
		for (int i = 1; i <= V; i++) {
			if (maxNodes[i] > max) {
				max = maxNodes[i];
				maxNode = i;
			}
		}

		int maxResult = Arrays.stream(dijkstra(maxNode))
				.max()
				.getAsInt();

		System.out.println(maxResult);
	}

	private static int[] dijkstra(int start) {
		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MIN_VALUE);
		dist[start] = 0;

		boolean[] visited = new boolean[V + 1];

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			int current = pq.poll().destination;
			if (visited[current]) {
				continue;
			}
			visited[current] = true;

			for (Node node : tree.get(current)) {
				int next = node.destination;
				int cost = node.cost;
				if (visited[next] || dist[next] >= dist[current] + cost) {
					continue;
				}
				dist[next] = dist[current] + cost;
				pq.add(new Node(next, dist[next]));
			}
		}

		return dist;
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
			return o.cost - this.cost;
		}
	}

}
