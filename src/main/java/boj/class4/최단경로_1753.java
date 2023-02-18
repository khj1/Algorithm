package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로_1753 {

	static int nodeCount;
	static int pathCount;
	static int startPoint;
	static int[] dist;
	static List<List<Node>> network;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		nodeCount = Integer.parseInt(st.nextToken());
		pathCount = Integer.parseInt(st.nextToken());
		startPoint = Integer.parseInt(br.readLine());
		dist = new int[nodeCount + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);

		network = new ArrayList<>();
		for (int i = 0; i <= nodeCount; i++) {
			network.add(new ArrayList<>());
		}

		for (int i = 0; i < pathCount; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st2.nextToken());
			int end = Integer.parseInt(st2.nextToken());
			int weight = Integer.parseInt(st2.nextToken());

			network.get(start).add(new Node(end, weight));
		}

		bfs();

		for (int i = 1; i <= nodeCount; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}

	private static void bfs() {
		boolean[] visited = new boolean[nodeCount + 1];
		dist[startPoint] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(startPoint, 0));

		while (!pq.isEmpty()) {
			Node polledNode = pq.poll();
			int current = polledNode.destination;
			if (visited[current]) {
				continue;
			}
			visited[current] = true;

			for (Node next : network.get(current)) {
				if (visited[next.destination] || dist[next.destination] < dist[current] + next.weight) {
					continue;
				}
				dist[next.destination] = dist[current] + next.weight;
				pq.add(new Node(next.destination, dist[next.destination]));
			}
		}

	}

	static class Node implements Comparable<Node> {
		int destination;
		int weight;

		public Node(int destination, int weight) {
			this.destination = destination;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

}
