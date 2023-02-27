package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의_지름_1967 {
	static int n;
	static List<List<Node>> paths;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1];
		paths = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			paths.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int departure = Integer.parseInt(st.nextToken());
			int destination = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			paths.get(departure).add(new Node(destination, cost));
			paths.get(destination).add(new Node(departure, cost));
		}

		for (int i = 1; i <= n; i++) {
			visited[i] = true;
			dfs(i, 0);
			visited[i] = false;
		}
		System.out.println(max);
	}

	private static void dfs(int start, int sum) {
		for (Node node : paths.get(start)) {
			int destination = node.destination;
			int cost = node.cost;
			if (visited[destination]) {
				continue;
			}
			visited[destination] = true;
			dfs(destination, sum + cost);
			visited[destination] = false;
		}
		max = Math.max(max, sum);
	}

	private static class Node {
		int destination;
		int cost;

		public Node(int destination, int cost) {
			this.destination = destination;
			this.cost = cost;
		}
	}
}
