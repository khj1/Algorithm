package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의_부모_11725 {

	static int N;
	static int[] parents;
	static boolean[] visited;
	static ArrayList<Integer>[] network;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		parents = new int[N + 1];
		visited = new boolean[N + 1];
		network = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			network[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			network[a].add(b);
			network[b].add(a);
		}

		visited[1] = true;
		findParents(1);

		for (int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}
	}

	private static void findParents(int root) {
		for (int i : network[root]) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			parents[i] = root;
			findParents(i);
		}
	}
}
