package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TODO
public class 숨바꼭질_1697 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if (N == K) {
			System.out.println(0);
		} else {
			bfs(N, K);
		}
	}

	private static void bfs(int N, int K) {
		int[] time = new int[100_001];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		time[N] = 1;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int i = 0; i < 3; i++) {
				int next;
				if (i == 0) {
					next = current + 1;
				} else if (i == 1) {
					next = current - 1;
				} else {
					next = current * 2;
				}
				if (next == K) {
					System.out.println(time[current]);
					return;
				}
				if (next >= 0 && next <= 100000 && time[next] == 0) {
					queue.add(next);
					time[next] = time[current] + 1;
				}
			}
		}
	}
}
