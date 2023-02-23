package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파티_1238 {

	static int N;
	static int M;
	static int X;
	static List<List<Node>> partyGraph;
	static List<List<Node>> homeGraph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		partyGraph = new ArrayList<>();
		homeGraph = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			partyGraph.add(new ArrayList<>());
			homeGraph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());

			int departure = Integer.parseInt(st2.nextToken());
			int destination = Integer.parseInt(st2.nextToken());
			int cost = Integer.parseInt(st2.nextToken());

			partyGraph.get(departure).add(new Node(destination, cost));
			homeGraph.get(destination).add(new Node(departure, cost));
		}

		int[] partyDist = dijkstra(partyGraph);
		int[] homeDist = dijkstra(homeGraph);

		int max = Integer.MIN_VALUE;

		for (int i = 1; i <= N; i++) {
			max = Math.max(max, partyDist[i] + homeDist[i]);
		}

		System.out.println(max);
	}

	private static int[] dijkstra(List<List<Node>> graph) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;

		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(X, 0));

		while (!pq.isEmpty()) {
			int current = pq.poll().destination;
			if (visited[current]) {
				continue;
			}
			visited[current] = true;

			for (Node next : graph.get(current)) {
				if (visited[next.destination] || dist[next.destination] <= dist[current] + next.cost) {
					continue;
				}
				dist[next.destination] = dist[current] + next.cost;
				pq.add(new Node(next.destination, dist[next.destination]));
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
			return this.cost - o.cost;
		}
	}

}
