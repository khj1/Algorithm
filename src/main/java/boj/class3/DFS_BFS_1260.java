package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class DFS_BFS_1260 {

	private static int N;
	private static int M;
	private static int V;
	private static List<Integer> bfsResult = new ArrayList<>();
	private static List<Integer> dfsResult = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		int[][] graph = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st2.nextToken());
			int y = Integer.parseInt(st2.nextToken());

			graph[x][y] = 1;
			graph[y][x] = 1;
		}

		dfs(graph, V);
		bfs(graph);

		String dfsString = dfsResult.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(" "));

		String bfsString = bfsResult.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(" "));

		System.out.println(dfsString);
		System.out.println(bfsString);
	}

	private static void dfs(int[][] graph, int v) {
		dfsResult.add(v);
		if (dfsResult.size() >= N) {
			return;
		}
		for (int i = 1; i <= N; i++) {
			int connection = graph[v][i];
			if (connection == 1 && !dfsResult.contains(i)) {
				dfs(graph, i);
			}
		}
	}

	private static void bfs(int[][] graph) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(V);
		bfsResult.add(V);

		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			for (int i = 1; i <= N; i++) {
				int connection = graph[current][i];
				if (connection == 1 && !bfsResult.contains(i)) {
					bfsResult.add(i);
					queue.add(i);
				}
			}
		}
	}
}
