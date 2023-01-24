package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 바이러스_2606 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[][] network = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			network[a][b] = 1;
			network[b][a] = 1;
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);

		Set<Integer> infected = new HashSet<>();
		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (network[current][i] == 1) {
					network[current][i] = 0;
					network[i][current] = 0;
					infected.add(i);
					queue.add(i);
				}
			}
		}
		System.out.println(infected.size());
	}
}
