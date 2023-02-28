package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질3_13549 {

	static int min = Integer.MAX_VALUE;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		bfs(N, K);

		System.out.println(min);
	}

	private static void bfs(int start, int end) {
		visited = new boolean[1_000_000];

		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(start, 0));

		while (!queue.isEmpty()) {
			Position position = queue.poll();
			int current = position.current;
			int count = position.count;

			if (current == end) {
				min = Math.min(min, count);
				continue;
			}
			if (current > end) {
				min = Math.min(min, count + current - end);
				continue;
			}

			int up = current + 1;
			int down = current - 1;
			int doubleUp = current * 2;

			if (!visited[doubleUp]) {
				visited[doubleUp] = true;
				queue.add(new Position(doubleUp, count));
			}
			if (down >= 0 && !visited[down]) {
				visited[down] = true;
				queue.add(new Position(down, count + 1));
			}
			if (!visited[up]) {
				visited[up] = true;
				queue.add(new Position(up, count + 1));
			}
		}
	}

	static class Position {
		int current;
		int count;

		public Position(int current, int count) {
			this.current = current;
			this.count = count;
		}
	}

}
