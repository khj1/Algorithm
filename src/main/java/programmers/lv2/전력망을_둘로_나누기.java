package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/86971
 */
public class 전력망을_둘로_나누기 {
	private boolean[][] isConnected;

	public int solution(int n, int[][] wires) {
		int min = Integer.MAX_VALUE;
		isConnected = new boolean[n + 1][n + 1];

		for (int[] wire : wires) {
			isConnected[wire[0]][wire[1]] = true;
			isConnected[wire[1]][wire[0]] = true;
		}

		for (int[] wire : wires) {
			isConnected[wire[0]][wire[1]] = false;
			isConnected[wire[1]][wire[0]] = false;

			min = Math.min(min, bfs(1, n));

			isConnected[wire[0]][wire[1]] = true;
			isConnected[wire[1]][wire[0]] = true;
		}
		return min;
	}

	private int bfs(int pole, int n) {
		int cnt = 1;
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(pole);

		while (!queue.isEmpty()) {
			int polled = queue.poll();
			visited[polled] = true;
			for (int i = 1; i < n + 1; i++) {
				if (isConnected[polled][i] && !visited[i]) {
					queue.add(i);
					cnt++;
				}
			}
		}
		return Math.abs(cnt - (n - cnt));
	}
}
