package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연결_요소의_개수_11724 {

	private static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());

		int[][] network = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st2.nextToken());
			int v = Integer.parseInt(st2.nextToken());

			network[u][v] = 1;
			network[v][u] = 1;
		}
		boolean[] visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				count++;
				bfs(network, visited, i);
			}
		}
		System.out.println(count);
	}

	private static void bfs(int[][] network, boolean[] visited, int i) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		while (!queue.isEmpty()) {
			Integer current = queue.poll();

			for (int j = 1; j < network[0].length; j++) {
				if (network[current][j] == 0 || visited[j]) {
					continue;
				}
				visited[j] = true;
				queue.add(j);
			}
		}
	}
}
