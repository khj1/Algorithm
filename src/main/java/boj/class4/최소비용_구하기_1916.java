package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//TODO
public class 최소비용_구하기_1916 {

	static int N;
	static int M;
	static ArrayList<ArrayList<Node>> a;
	static int[] dist;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		a = new ArrayList<>();
		dist = new int[N + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i <= N; i++) {
			a.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			a.get(start).add(new Node(end, cost));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int departure = Integer.parseInt(st.nextToken());
		int destination = Integer.parseInt(st.nextToken());

		dijkstra(departure);

		System.out.println(dist[destination]);
	}

	private static void dijkstra(int departure) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visited = new boolean[N + 1];
		pq.add(new Node(departure, 0));
		dist[departure] = 0;

		while (!pq.isEmpty()) {
			int current = pq.poll().destination;

			if (visited[current]) {
				continue;
			}
			visited[current] = true;

			for (Node node : a.get(current)) {
				if (visited[node.destination] || dist[node.destination] <= dist[current] + node.cost) {
					continue;
				}
				dist[node.destination] = dist[current] + node.cost;
				pq.add(new Node(node.destination, dist[node.destination]));
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
