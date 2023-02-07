package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 케빈_베이컨의_6단계_법칙_1389 {

	static int N;
	static int M;
	static int[][] network;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		network = new int[N + 1][N + 1];
		initNetwork(br, M);

		int min = Integer.MAX_VALUE;
		int minPerson = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					continue;
				}
				sum += bfs(i, j);
			}
			if (min == sum) {
				minPerson = Math.min(minPerson, i);
			} else if (min > sum) {
				min = sum;
				minPerson = i;
			}
		}
		System.out.println(minPerson);
	}

	private static int bfs(int start, int end) {
		int[] count = new int[N + 1];
		boolean[][] visited = new boolean[N + 1][N + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (current == i || i == start) {
					continue;
				}
				if (visited[current][i] || network[current][i] != 1) {
					continue;
				}
				if (i == end) {
					return count[current] + 1;
				}
				count[i] = count[current] + 1;
				visited[current][i] = true;
				visited[i][current] = true;
				queue.add(i);
			}
		}
		return 0;
	}

	private static void initNetwork(BufferedReader br, int M) throws IOException {
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st2.nextToken());
			int q = Integer.parseInt(st2.nextToken());
			network[p][q] = 1;
			network[q][p] = 1;
		}
	}
}
